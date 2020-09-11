package net.moxuan.admin.service;

import net.moxuan.common.entity.SysLog;

/**
 * @author: moxuan
 * @description:
 */
public interface SysLogService {

    /**
     * 保存日志信息
     *
     * @param sysLog 日志信息
     * @return long 主键
     **/
    long save(SysLog sysLog);
}
