package net.moxuan.common.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.moxuan.common.entity.SysDept;
import net.moxuan.common.mapper.SysDeptMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@Component
public class SysDeptManager {

    @Resource
    private SysDeptMapper deptMapper;

    public int queryCountByParentId(long orgId, long parentId) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        wrapper.eq("org_id", orgId).eq("parent_id", parentId);
        return deptMapper.selectCount(wrapper);
    }

    public int queryCountByName(String orgId, String name) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_name", name).eq("org_id", orgId);
        return deptMapper.selectCount(wrapper);
    }

    public List<SysDept> queryList(long orgId) {
        SysDept dept = new SysDept();
        dept.setOrgId(orgId);
        return deptMapper.selectList(generatorWrapper(dept));
    }

    public int save(SysDept dept) {
        return deptMapper.insert(dept);
    }

    private QueryWrapper<SysDept> generatorWrapper(SysDept dept) {
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>(dept);
        wrapper.select("id", "dept_name", "code", "sort_no", "path", "parent_id as pid", "org_id", "is_enabled as enabled");
        wrapper.orderByAsc("path", "sort_no", "dept_name");
        return wrapper;
    }

}
