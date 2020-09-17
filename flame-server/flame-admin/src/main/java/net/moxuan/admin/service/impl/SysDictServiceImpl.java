package net.moxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.dto.SysDictDTO;
import net.moxuan.admin.service.SysDictService;
import net.moxuan.common.entity.SysDict;
import net.moxuan.common.enums.ResultCodeEnum;
import net.moxuan.common.manager.SysDictManager;
import net.moxuan.common.util.CheckUtil;
import net.moxuan.common.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@Slf4j
@Service
public class SysDictServiceImpl implements SysDictService {

    @Resource
    private SysDictManager dictManager;

    @Resource
    private MapperFactory mapperFactory;

    @Override
    public int deleteBatch(String ids) {
        return dictManager.deleteBatch(StringUtil.stringToList(ids));
    }

    @Override
    public int deleteById(String id) {
        return dictManager.deleteById(id);
    }

    @Override
    public int queryByCode(String code) {
        return dictManager.queryByCode(code);
    }

    @Override
    public IPage<SysDictDTO> page(IPage<SysDictDTO> page, Wrapper<SysDictDTO> queryWrapper) {
        SysDict dict = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysDict.class);

        Page<SysDict> pageDict = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysDict> list = dictManager.queryPage(pageDict, dict);

        this.pojoToDto(list, page);
        return page;
    }

    @Override
    public List<SysDictDTO> queryList(boolean enabled) {
        List<SysDict> list = dictManager.queryList(enabled);
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return mapperFactory.getMapperFacade().mapAsList(list, SysDictDTO.class);
    }

    @Override
    public long save(SysDictDTO dto) {
        int count = this.queryByCode(dto.getCode().trim());
        CheckUtil.notExits(count, ResultCodeEnum.CODE_EXIST.code(), ResultCodeEnum.CODE_EXIST.desc());

        SysDict dict = mapperFactory.getMapperFacade().map(dto, SysDict.class);
        dict.setGmtCreate(LocalDateTime.now());
        dict.setGmtModified(LocalDateTime.now());
        dict.setEnabled(true);
        dict.setDeleted(false);
        dictManager.save(dict);

        if (log.isInfoEnabled()) {
            log.info("新增字典：{}", dict);
        }

        return dict.getId();
    }

    @Override
    public int update(SysDictDTO dto) {
        SysDict dict = mapperFactory.getMapperFacade().map(dto, SysDict.class);
        return dictManager.updateById(dict);
    }

    private void pojoToDto (IPage<SysDict> list, IPage<SysDictDTO> page) {
        if (list != null && list.getSize() > 0) {
            List<SysDictDTO> dots = new ArrayList<>();

            List<SysDict> records = list.getRecords();

            for (SysDict dict : records) {
                SysDictDTO dto = mapperFactory.getMapperFacade().map(dict, SysDictDTO.class);
                dots.add(dto);
            }
            page.setTotal(list.getTotal());
            page.setSize(list.getSize());
            page.setRecords(dots);
        }
    }
}
