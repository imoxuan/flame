package net.moxuan.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.system.dto.SysOrganizationDTO;
import net.moxuan.system.entity.SysOrganization;
import net.moxuan.system.mapper.SysOrganizationMapper;
import net.moxuan.system.service.SysOrganizationService;
import net.moxuan.validator.SysOrganizationValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description: 集团表 服务实现类
 */
@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {

    private static final Logger logger = LoggerFactory.getLogger(SysOrganizationServiceImpl.class);

    @Resource
    private SysOrganizationMapper organizationMapper;

    @Override
    public long save(SysOrganization organization) {
        //TODO 校验参数
        SysOrganizationValid.valid(organization);
        return organizationMapper.insert(organization);
    }

  /*  @Override
    public Result<?> queryPageList() {
        *//*List<SysOrganization> list = organizationMapper.queryAll();
        System.out.println(list.toString());
        List<SysOrganizationDTO> dtos = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (SysOrganization org : list) {
                SysOrganizationDTO dto = new SysOrganizationDTO();
                dto.setId(org.getId().toString());
                dto.setName(org.getName());
                dto.setEnName(org.getEnName());
                dto.setCode(org.getCode());
                dto.setShortName(org.getShortName());
                dto.setSortNo(org.getSortNo());
                dto.setEnabled(org.getEnabled());
                dtos.add(dto);
            }
        }
        return ResultGenerator.success(dtos);*//*
        return null;
    }

    @Override
    public Result<?> deleteBatch(String ids) {
        *//*List<String> list = Arrays.asList(ids.split(","));
        int count = organizationMapper.deleteBatch(list);
        return ResultGenerator.success("成功删除数据: " + count + " 条");*//*
        return null;
    }

    @Override
    public Result<?> updateById(SysOrganization organization) {
        return null;
    }*/

    @Override
    public List<SysOrganizationDTO> queryAll() {
        logger.info("queryAll start...");
        List<SysOrganization> list = organizationMapper.selectList(null);
        logger.info("queryAll end. data size:{}", list == null ? 0 : list.size());

        List<SysOrganizationDTO> dtos = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (SysOrganization org : list) {
                SysOrganizationDTO dto = new SysOrganizationDTO();
                dto.setId(org.getId().toString());
                dto.setName(org.getName());
                dto.setEnName(org.getEnName());
                dto.setCode(org.getCode());
                dto.setShortName(org.getShortName());
                dto.setSortNo(org.getSortNo());
                dto.setEnabled(org.getEnabled());
                dtos.add(dto);
            }
        }
        return dtos;
    }

    @Override
    public IPage<SysOrganizationDTO> page(IPage<SysOrganizationDTO> page, Wrapper<SysOrganizationDTO> queryWrapper) {
        Page<SysOrganization> pageOrg = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysOrganization> list = organizationMapper.selectPage(pageOrg, null);
        this.pojoToDto(list, page);
        return page;
    }

    private void pojoToDto (IPage<SysOrganization> list, IPage<SysOrganizationDTO> page) {
        if (list != null && list.getSize() > 0) {
            List<SysOrganizationDTO> dots = new ArrayList<>();

            List<SysOrganization> records = list.getRecords();

            for (SysOrganization org : records) {
                SysOrganizationDTO dto = new SysOrganizationDTO();
                BeanUtils.copyProperties(org, dto);
                dto.setId(org.getId().toString());
                dots.add(dto);
            }
            page.setRecords(dots);
        }
    }
}
