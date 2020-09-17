package net.moxuan.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import net.moxuan.admin.dto.SysDictItemDTO;
import net.moxuan.admin.service.SysDictItemService;
import net.moxuan.common.entity.SysDictItem;
import net.moxuan.common.enums.ResultCodeEnum;
import net.moxuan.common.manager.SysDictItemManager;
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
public class SysDictItemServiceImpl implements SysDictItemService {

    @Resource
    private SysDictItemManager dictItemManager;

    @Resource
    private MapperFactory mapperFactory;

    @Override
    public int deleteBatch(String ids) {
        return dictItemManager.deleteBatch(StringUtil.stringToList(ids));
    }

    @Override
    public int deleteById(String id) {
        return dictItemManager.deleteById(id);
    }

    @Override
    public int queryByCode(String code) {
        return dictItemManager.queryByCode(code);
    }

    @Override
    public IPage<SysDictItemDTO> page(IPage<SysDictItemDTO> page, Wrapper<SysDictItemDTO> queryWrapper) {
        SysDictItem dictItem = mapperFactory.getMapperFacade().map(queryWrapper.getEntity(), SysDictItem.class);

        Page<SysDictItem> pageDict = new Page<>(page.getCurrent(), page.getSize());
        IPage<SysDictItem> list = dictItemManager.queryPage(pageDict, dictItem);

        this.pojoToDto(list, page);
        return page;
    }

    @Override
    public List<SysDictItemDTO> queryList(boolean enabled, SysDictItemDTO dto) {
        List<SysDictItem> list = dictItemManager.queryList(enabled, mapperFactory.getMapperFacade().map(dto, SysDictItem.class));
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return mapperFactory.getMapperFacade().mapAsList(list, SysDictItemDTO.class);
    }

    @Override
    public long save(SysDictItemDTO dto) {
        // TODO 词判断需要修改
        int count = this.queryByCode(dto.getDictCode().trim());
        CheckUtil.notExits(count, ResultCodeEnum.CODE_EXIST.code(), ResultCodeEnum.CODE_EXIST.desc());

        SysDictItem dictItem = mapperFactory.getMapperFacade().map(dto, SysDictItem.class);
        dictItem.setGmtCreate(LocalDateTime.now());
        dictItem.setGmtModified(LocalDateTime.now());
        dictItem.setEnabled(true);
        dictItemManager.save(dictItem);

        if (log.isInfoEnabled()) {
            log.info("新增字典项：{}", dictItem);
        }

        return dictItem.getId();
    }

    @Override
    public int update(SysDictItemDTO dto) {
        SysDictItem dictItem = mapperFactory.getMapperFacade().map(dto, SysDictItem.class);
        return dictItemManager.updateById(dictItem);
    }

    private void pojoToDto (IPage<SysDictItem> list, IPage<SysDictItemDTO> page) {
        if (list != null && list.getSize() > 0) {
            List<SysDictItemDTO> dots = new ArrayList<>();

            List<SysDictItem> records = list.getRecords();

            for (SysDictItem dictItem : records) {
                SysDictItemDTO dto = mapperFactory.getMapperFacade().map(dictItem, SysDictItemDTO.class);
                dots.add(dto);
            }
            page.setTotal(list.getTotal());
            page.setSize(list.getSize());
            page.setRecords(dots);
        }
    }
}
