package net.moxuan.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.constant.ErrorCodeConst;
import net.moxuan.system.dto.SysOrgDTO;
import net.moxuan.system.entity.SysOrg;
import net.moxuan.system.mapper.SysOrgMapper;
import net.moxuan.system.service.SysOrgService;
import net.moxuan.util.CheckUtil;
import net.moxuan.validator.SysOrgValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: moxuan
 * @description: 机构表 服务实现类
 */
@Service
public class SysOrgServiceImpl implements SysOrgService {

    private static final Logger logger = LoggerFactory.getLogger(SysOrgServiceImpl.class);

    @Resource
    private SysOrgMapper orgMapper;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public int deleteBatch(String ids) {
        // TODO 验证参数
        logger.info("batch delete sysOrg, ids: {}", ids);
        int count = orgMapper.deleteBatchIds(Arrays.asList(ids.split(",")));
        logger.info("batch delete sysOrg success, count: {}", count);
        return count;
    }

    @Override
    public int deleteById(String id) {
        // TODO id 要校验
        logger.info("delete sysOrg, id: {}", id);
        int count = orgMapper.deleteById(Long.valueOf(id));
        logger.info("delete sysOrg success, count: {}", count);
        return count;
    }

    @Override
    public IPage<SysOrgDTO> page(IPage<SysOrgDTO> page, Wrapper<SysOrgDTO> queryWrapper) {
        // TODO 处理 queryWrapper
        logger.info("query param {}, {}", page, queryWrapper);

        SysOrg org = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysOrg.class);
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<>(org);
        wrapper.orderByAsc("sort_no", "name");

        Page<SysOrg> pageOrg = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysOrg> list = orgMapper.selectPage(pageOrg, wrapper);

        logger.info("query data {}", list.getSize());

        this.pojoToDto(list, page);
        return page;
    }

    @Override
    public List<SysOrgDTO> queryAll() {
        List<SysOrg> list = orgMapper.selectList(null);
        if (list == null) {
            return new ArrayList<>();
        }
        return mapperFactory.getMapperFacade().mapAsList(list, SysOrgDTO.class);
    }

    @Override
    public int queryByCode(String code) {
        return orgMapper.selectCount(new QueryWrapper<SysOrg>().eq("code", code));
    }

    @Override
    public int queryByName(String name) {
        return orgMapper.selectCount(new QueryWrapper<SysOrg>().eq("name", name));
    }

    @Override
    public long save(SysOrgDTO dto) {
        SysOrgValid.valid(dto);

        // 校验名称、编码是否已存在
        int count = this.queryByName(dto.getName());
        CheckUtil.notExits(count, ErrorCodeConst.ORG_NAME_EXIST, "机构名称已存在");

        count = this.queryByCode(dto.getCode());
        CheckUtil.notExits(count, ErrorCodeConst.ORG_CODE_EXIST, "机构编码已存在");

        SysOrg organization = mapperFactory.getMapperFacade().map(dto, SysOrg.class);
        organization.setGmtCreate(LocalDateTime.now());
        organization.setGmtModified(LocalDateTime.now());
        organization.setEnabled(true);
        organization.setDeleted(false);

        return orgMapper.insert(organization);
    }

    @Override
    public int update(SysOrgDTO dto) {
        SysOrg org = mapperFactory.getMapperFacade().map(dto, SysOrg.class);
        return orgMapper.updateById(org);
    }

    private void pojoToDto (IPage<SysOrg> list, IPage<SysOrgDTO> page) {
        if (list != null && list.getSize() > 0) {
            List<SysOrgDTO> dots = new ArrayList<>();

            List<SysOrg> records = list.getRecords();

            for (SysOrg org : records) {
                SysOrgDTO dto = mapperFactory.getMapperFacade().map(org, SysOrgDTO.class);
                dots.add(dto);
            }
            page.setTotal(list.getTotal());
            page.setSize(list.getSize());
            page.setRecords(dots);
        }
    }
}
