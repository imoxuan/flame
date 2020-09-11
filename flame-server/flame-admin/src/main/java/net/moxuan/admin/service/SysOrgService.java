package net.moxuan.admin.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.moxuan.common.dto.SysOrgDTO;
import net.moxuan.common.entity.SysOrg;

import java.util.List;

/**
 * @author: moxuan
 * @description: 机构表 服务
 */
public interface SysOrgService {


    /**
     * 根据 ids 删除
     *
     * @param ids id1,id2 逗号分隔
     * @return int
     */
    int deleteBatch(String ids);

    /**
     * 根据 id 删除
     *
     * @param id id
     * @return int
     */
    int deleteById(String id);

    /**
     * 分页查询机构信息
     *
     * @param page 分页信息
     * @param queryWrapper 查询条件
     * @return IPage<SysOrgDTO> 分页结果
     */
    IPage<SysOrgDTO> page(IPage<SysOrgDTO> page, Wrapper<SysOrgDTO> queryWrapper);

    /**
     * 根据所有机构信息
     *
     * @return List<SysOrg>
     */
    List<SysOrgDTO> queryAll();

    /**
     * 根据编码查询记录数
     *
     * @param code 编码
     * @return int
     */
    int queryByCode(String code);

    /**
     * 根据名称查询记录数
     *
     * @param name 名称
     * @return int
     */
    int queryByName(String name);

    /**
     * 保存机构信息
     *
     * @param dto 机构信息
     * @return long 执行条数
     */
    long save(SysOrgDTO dto);

    /**
     * 修改
     *
     *  @param dto 机构信息
     * @return int
     */
    int update(SysOrgDTO dto);

    /**
     * 根据 id 查询机构信息
     *
     *  @param id 主键
     * @return SysOrg
     */
    SysOrg queryById(String id);
}
