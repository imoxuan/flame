package net.moxuan.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.moxuan.system.entity.SysLog;

/**
 * @author: moxuan
 * @description:
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * 保存系统日志
     *
     * @param sysLog 系统日志对象
     * @return int 执行条数
     */
    int save(SysLog sysLog);
}
