package net.moxuan.service;

import net.moxuan.entity.SysOrganization;
import net.moxuan.vo.Result;

/**
 * @author: moxuan
 * @description: 集团表 服务
 */
public interface SysOrganizationService {

    /**
     * 保存集团信息
     *
     * @param organization 集团信息
     * @return Result<SysOrganization>
     **/
    Result<SysOrganization> save(SysOrganization organization);
}
