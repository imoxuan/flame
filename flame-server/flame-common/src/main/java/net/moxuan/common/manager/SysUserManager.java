package net.moxuan.common.manager;

import net.moxuan.common.mapper.SysUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: moxuan
 * @description:
 */
@Component
public class SysUserManager {

    @Resource
    private SysUserMapper userMapper;
}
