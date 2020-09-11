package net.moxuan.admin.service.impl;

import net.moxuan.admin.service.SysLogService;
import net.moxuan.common.entity.SysLog;
import net.moxuan.common.mapper.SysLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: moxuan
 * @description: 日志实现类
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public long save(SysLog sysLog) {
        sysLog.setGmtCreate(LocalDateTime.now());
        sysLog.setGmtModified(LocalDateTime.now());
        return sysLogMapper.insert(sysLog);
    }
}
