package net.moxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.service.SysDeptService;
import net.moxuan.admin.dto.DeptTreeDTO;
import net.moxuan.admin.dto.SysDeptDTO;
import net.moxuan.common.entity.SysDept;
import net.moxuan.common.entity.SysOrg;
import net.moxuan.common.enums.ResultCodeEnum;
import net.moxuan.common.mapper.SysDeptMapper;
import net.moxuan.common.mapper.SysOrgMapper;
import net.moxuan.common.util.CheckUtil;
import net.moxuan.common.vo.NodeIcon;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: moxuan
 * @description:
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {
    /**
     * 编号起始值
     */
    private final long START_NO = 1001L;

    @Resource
    private MapperFactory mapperFactory;

    @Resource
    private SysDeptMapper deptMapper;

    @Resource
    private SysOrgMapper orgMapper;

    @Override
    public int queryByName(String name) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        // TODO org_id
        wrapper.eq("name", name).eq("org_id", "");
        return deptMapper.selectCount(wrapper);
    }

    @Override
    public int save(SysDeptDTO dto) {
        //SysDeptValid.valid(dto);

        // 校验名称
        int count = this.queryByName(dto.getName());
        CheckUtil.notExits(count, ResultCodeEnum.NAME_EXIST.code(), ResultCodeEnum.NAME_EXIST.desc());

        SysDept dept = mapperFactory.getMapperFacade().map(dto, SysDept.class);
        dept.setGmtCreate(LocalDateTime.now());
        dept.setGmtModified(LocalDateTime.now());
        dept.setEnabled(true);
        dept.setDeleted(false);
        // TODO setOrgId setPath
        dept.setPath(generatorDeptPath(dept.getPid(), dept.getOrgId(), dept.getPath()));

        return deptMapper.insert(dept);
    }

    @Override
    public List<DeptTreeDTO> queryDeptTree(String orgId) {
        // TODO 获取机构信息，现在从数据库中直接取，将来放入 redis
        // 当前
        SysOrg org = orgMapper.selectById(orgId);

        // TODO 查询指定orgId, 字段，排序
        List<SysDept> deptList = deptMapper.selectList(generatorWrapper(null));

        List<DeptTreeDTO> dtos = new ArrayList<>();

        DeptTreeDTO dto = new DeptTreeDTO();
        dto.setKey(org.getId().toString());
        dto.setTitle(org.getName());
        dto.setPath(null);
        dto.setLevel(1);
        dtos.add(dto);

        buildTree(dto, deptList, 1);
        return dtos;
    }

    public void buildTree(DeptTreeDTO parentNode, List<SysDept> deptList, int level) {
        List<SysDept> newDeptList;

        if (level == 1) {
            newDeptList = deptList.stream().filter(item -> item.getPath().length() == 4).collect(Collectors.toList());
        } else {
            newDeptList = deptList.stream().filter(item -> item.getPid().toString().equals(parentNode.getKey())).collect(Collectors.toList());
        }

        if (newDeptList.isEmpty()) {
            parentNode.setIsLeaf(true);
        } else {
            newDeptList.forEach(dept -> {
                DeptTreeDTO dto = new DeptTreeDTO();
                dto.setKey(dept.getId().toString());
                dto.setTitle(dept.getName());
                dto.setPath(dept.getPath());
                dto.setLevel(level + 1);
                dto.setSlots(new NodeIcon().setIcon("icon"));
                parentNode.addChild(dto);
                parentNode.setIsLeaf(false);

                buildTree(dto, deptList, level + 1);
            });
        }
    }

    /**
     * 生成部门路径
     * 以下约定：
     * 一级路径 从1001 编号开始，依次递增
     * 二级路径 开头1001 + 1001
     * 以此类推。。。
     *
     * @param parentId 父id
     * @param orgId 机构id
     * @return String 部门路径
     */
    public String generatorDeptPath(long parentId, long orgId, String parentPath) {
        String path = "";

        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        wrapper.eq("org_id", orgId).eq("parent_id", parentId);
        int count = deptMapper.selectCount(wrapper);
        // 一级
        if (parentId == orgId) {
            path = String.valueOf(START_NO + count);
        } else {
            long parentPathLong = Long.parseLong(parentPath);
            path = String.valueOf(parentPathLong + count);
        }
        return path;
    }

    private QueryWrapper<SysDept> generatorWrapper(SysDept dept) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>(dept);
        wrapper.select("id", "name", "code", "sort_no", "path", "parent_id as pid", "org_id", "is_enabled as enabled");
        wrapper.orderByAsc("path", "sort_no", "name");
        return wrapper;
    }
}
