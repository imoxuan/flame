package net.moxuan.system.service.impl;

import net.moxuan.system.entity.SysLog;
import net.moxuan.system.mapper.SysLogMapper;
import net.moxuan.system.service.SysLogService;
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
