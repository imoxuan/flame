package net.moxuan.common.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.common.entity.SysUser;
import net.moxuan.common.mapper.SysUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author: moxuan
 * @description:
 */
@Component
public class SysUserManager {

    @Resource
    private SysUserMapper userMapper;

    public int deleteBatch(Collection<String> ids) {
        return userMapper.deleteBatchIds(ids);
    }

    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    public IPage<SysUser> queryPage(Page<SysUser> page, SysUser user) {
        return userMapper.selectPage(page, generatorWrapper(user));
    }

    public int save(SysUser user) {
        return userMapper.insert(user);
    }
    public int updateById(SysUser user) {
        return userMapper.updateById(user);
    }

    public SysUser selectById(String id) {
        return userMapper.selectById(id);
    }

    private QueryWrapper<SysUser> generatorWrapper(SysUser user) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>(user);
        wrapper.select("id", "name", "login_name", "user_no", "nick_name", "sort_no", "is_internal as internal",
                "is_virtual as virtual", "is_admin as admin", "gender", "state", "birthday", "account_state",
                "work_start_date", "user_type", "inside_tel", "outside_tel", "office", "mobile", "email", "org_id",
                "is_enabled as enabled");
        wrapper.orderByAsc("sort_no", "name");
        return wrapper;
    }
}
