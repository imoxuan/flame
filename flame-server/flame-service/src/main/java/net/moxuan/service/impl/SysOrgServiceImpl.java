package net.moxuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.common.constant.ErrorCodeConst;
import net.moxuan.common.dto.SysOrgDTO;
import net.moxuan.common.util.CheckUtil;
import net.moxuan.entity.SysOrg;
import net.moxuan.mapper.SysOrgMapper;
import net.moxuan.service.SysOrgService;
import net.moxuan.service.validator.SysOrgValid;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description: 机构表 服务实现类
 */
@Slf4j
@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private MapperFactory mapperFactory;

    @Override
    public int deleteBatch(String ids) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public IPage<SysOrgDTO> page(IPage<SysOrgDTO> page, Wrapper<SysOrgDTO> queryWrapper) {
        // TODO 处理 queryWrapper
        log.info("query param {}, {}", page, queryWrapper);

        SysOrg org = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysOrg.class);

        Page<SysOrg> pageOrg = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysOrg> list = sysOrgMapper.selectPage(pageOrg, this.generatorWrapper(org));

        log.info("query data {}", list.getSize());

        this.pojoToDto(list, page);
        return page;
    }

    @Override
    public List<SysOrgDTO> queryAll() {
        List<SysOrg> list = sysOrgMapper.selectList(this.generatorWrapper(null));
        if (list == null) {
            return new ArrayList<>();
        }
        return mapperFactory.getMapperFacade().mapAsList(list, SysOrgDTO.class);
    }

    @Override
    public int queryByCode(String code) {
        return 0;
    }

    @Override
    public int queryByName(String name) {
        return 0;
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

        return sysOrgMapper.insert(organization);
    }

    @Override
    public int update(SysOrgDTO dto) {
        SysOrg org = mapperFactory.getMapperFacade().map(dto, SysOrg.class);
        return sysOrgMapper.updateById(org);
    }

    private LambdaQueryWrapper<SysOrg> generatorWrapper(SysOrg org) {
        LambdaQueryWrapper<SysOrg> queryWrapper = new LambdaQueryWrapper<>(org);
        queryWrapper.select(SysOrg::getId, SysOrg::getName, SysOrg::getEnName, SysOrg::getShortName, SysOrg::getSortNo,
                SysOrg::getCode, SysOrg::getEnabled);
        return queryWrapper;
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
