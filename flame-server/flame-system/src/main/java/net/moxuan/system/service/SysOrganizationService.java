package net.moxuan.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.moxuan.system.dto.SysOrganizationDTO;
import net.moxuan.system.entity.SysOrganization;

import java.util.List;

/**
 * @author: moxuan
 * @description: 集团表 服务
 */
public interface SysOrganizationService {

    /**
     * 保存集团信息
     *
     * @param organization 集团信息
     * @return long 主键
     **/
    long save(SysOrganization organization);

   /* Result<?> queryPageList();

    Result<?> deleteBatch(String ids);

    Result<?> updateById(SysOrganization organization);*/

    List<SysOrganizationDTO> queryAll();

    IPage<SysOrganizationDTO> page(IPage<SysOrganizationDTO> page, Wrapper<SysOrganizationDTO> queryWrapper);
}
