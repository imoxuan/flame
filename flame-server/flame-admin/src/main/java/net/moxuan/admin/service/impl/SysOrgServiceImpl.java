package net.moxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.dto.SysOrgDTO;
import net.moxuan.admin.service.SysOrgService;
import net.moxuan.common.entity.SysOrg;
import net.moxuan.common.enums.ResultCodeEnum;
import net.moxuan.common.manager.SysOrgManager;
import net.moxuan.common.util.CheckUtil;
import net.moxuan.common.util.StringUtil;
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
    private SysOrgManager orgManager;

    @Resource
    private MapperFactory mapperFactory;

    @Override
    public int deleteBatch(String ids) {
        return orgManager.deleteBatch(StringUtil.stringToList(ids));
    }

    @Override
    public int deleteById(String id) {
        return orgManager.deleteById(id);
    }

    @Override
    public IPage<SysOrgDTO> page(IPage<SysOrgDTO> page, Wrapper<SysOrgDTO> queryWrapper) {
        // TODO 处理 queryWrapper
        SysOrg org = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysOrg.class);

        Page<SysOrg> pageOrg = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysOrg> list = orgManager.queryPage(pageOrg, org);

        this.pojoToDto(list, page);
        return page;
    }

    @Override
    public List<SysOrgDTO> queryAll() {
        List<SysOrg> list = orgManager.selectList(null);
        if (list == null) {
            return new ArrayList<>();
        }
        return mapperFactory.getMapperFacade().mapAsList(list, SysOrgDTO.class);
    }

    @Override
    public int queryByCode(String code) {
        return orgManager.queryByCode(code);
    }

    @Override
    public int queryByName(String name) {
        return orgManager.queryByName(name);
    }

    @Override
    public long save(SysOrgDTO dto) {
        // 校验名称、编码是否已存在
        int count = this.queryByName(dto.getName().trim());
        CheckUtil.notExits(count, ResultCodeEnum.NAME_EXIST.code(), ResultCodeEnum.NAME_EXIST.desc());

        count = this.queryByCode(dto.getCode().trim());
        CheckUtil.notExits(count, ResultCodeEnum.CODE_EXIST.code(), ResultCodeEnum.CODE_EXIST.desc());

        SysOrg org = mapperFactory.getMapperFacade().map(dto, SysOrg.class);
        org.setGmtCreate(LocalDateTime.now());
        org.setGmtModified(LocalDateTime.now());
        org.setEnabled(true);
        org.setDeleted(false);
        orgManager.save(org);

        if (log.isInfoEnabled()) {
            log.info("新增机构：{}", org);
        }

        return org.getId();
    }

    @Override
    public int update(SysOrgDTO dto) {
        SysOrg org = mapperFactory.getMapperFacade().map(dto, SysOrg.class);
        return orgManager.updateById(org);
    }

    @Override
    public SysOrg queryById(String id) {
        return orgManager.selectById(id);
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
