package net.moxuan.common.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.common.entity.SysDictItem;
import net.moxuan.common.mapper.SysDictItemMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@Repository
public class SysDictItemManager {

    @Resource
    private SysDictItemMapper dictItemMapper;

    public int queryByCode(String code) {
        QueryWrapper<SysDictItem> wrapper = new QueryWrapper<>();
        wrapper.eq("dict_code", code);
        return dictItemMapper.selectCount(wrapper);
    }

    public List<SysDictItem> queryList(boolean enabled, SysDictItem dictItem) {
        dictItem.setEnabled(enabled);
        return dictItemMapper.selectList(generatorWrapper(dictItem));
    }

    public IPage<SysDictItem> queryPage(Page<SysDictItem> page, SysDictItem dictItem) {
        return dictItemMapper.selectPage(page, generatorWrapper(dictItem));
    }

    private QueryWrapper<SysDictItem> generatorWrapper(SysDictItem dictItem) {
        QueryWrapper<SysDictItem> wrapper = new QueryWrapper<>(dictItem);
        wrapper.select("id", "dict_id", "dict_code", "item_key", "item_value", "sort_no", "description", "is_enabled as enabled");
        wrapper.orderByAsc("sort_no");
        return wrapper;
    }

    public int save(SysDictItem dictItem) {
        return dictItemMapper.insert(dictItem);
    }

    public int updateById(SysDictItem dictItem) {
        return dictItemMapper.updateById(dictItem);
    }

    public int deleteById(String id) {
        return dictItemMapper.deleteById(id);
    }

    public int deleteBatch(Collection<String> ids) {
        return dictItemMapper.deleteBatchIds(ids);
    }
}
