package net.moxuan.mapper;

import net.moxuan.entity.SysOrganization;

/**
 * @author: moxuan
 * @description: 集团信息 mapper
 */
public interface SysOrganizationMapper {

    /**
     * 根据编码查询集团数量
     *
     * @param code 集团编码
     * @return int 匹配条数
     **/
    int queryOrgByCode(String code);

    /**
     * 根据名称查询集团数量
     *
     * @param name 集团名称
     * @return int 匹配条数
     **/
    int queryOrgByName(String name);

    /**
     * 保存集团信息
     *
     * @param organization 集团信息
     * @return int 执行条数
     **/
    int save(SysOrganization organization);
}
