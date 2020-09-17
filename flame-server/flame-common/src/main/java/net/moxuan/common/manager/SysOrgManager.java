package net.moxuan.common.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.common.entity.SysOrg;
import net.moxuan.common.mapper.SysOrgMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@Component
public class SysOrgManager {

    @Resource
    private SysOrgMapper orgMapper;

    public int deleteBatch(Collection<String> ids) {
        return orgMapper.deleteBatchIds(ids);
    }

    public int deleteById(String id) {
        return orgMapper.deleteById(id);
    }


    public IPage<SysOrg> queryPage(Page<SysOrg> page, SysOrg org) {
        return orgMapper.selectPage(page, generatorWrapper(org));
    }

    public List<SysOrg> selectList(SysOrg org) {
        return orgMapper.selectList(generatorWrapper(org));
    }

    public int queryByCode(String code) {
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<>();
        wrapper.eq("code", code);
        return orgMapper.selectCount(wrapper);
    }
    public int queryByName(String name) {
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return orgMapper.selectCount(wrapper);
    }

    public int save(SysOrg org) {
        return orgMapper.insert(org);
    }
    public int updateById(SysOrg org) {
        return orgMapper.updateById(org);
    }

    public SysOrg selectById(String id) {
        return orgMapper.selectById(id);
    }

    private QueryWrapper<SysOrg> generatorWrapper(SysOrg org) {
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<>(org);
        wrapper.select("id", "name", "short_name", "sort_no", "code", "is_enabled as enabled");
        wrapper.orderByAsc("sort_no", "name");
        return wrapper;
    }
}
