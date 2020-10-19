package net.moxuan.common.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.common.entity.SysDict;
import net.moxuan.common.mapper.SysDictMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@Repository
public class SysDictManager {

    @Resource
    private SysDictMapper dictMapper;

    public int queryByCode(String code) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.eq("code", code);
        return dictMapper.selectCount(wrapper);
    }

    public List<SysDict> queryList(boolean enabled) {
        SysDict sysDict = new SysDict();
        sysDict.setEnabled(enabled);
        return dictMapper.selectList(generatorWrapper(sysDict));
    }

    public IPage<SysDict> queryPage(Page<SysDict> page, SysDict dict) {
        return dictMapper.selectPage(page, generatorWrapper(dict));
    }

    private QueryWrapper<SysDict> generatorWrapper(SysDict dict) {
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>(dict);
        wrapper.select("id", "code", "dict_name", "description", "is_enabled as enabled");
        wrapper.orderByAsc("dict_name");
        return wrapper;
    }

    public int save(SysDict dict) {
        return dictMapper.insert(dict);
    }

    public int updateById(SysDict dict) {
        return dictMapper.updateById(dict);
    }

    public int deleteById(String id) {
        return dictMapper.deleteById(id);
    }

    public int deleteBatch(Collection<String> ids) {
        return dictMapper.deleteBatchIds(ids);
    }
}
