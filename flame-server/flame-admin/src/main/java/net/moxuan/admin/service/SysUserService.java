package net.moxuan.admin.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.moxuan.admin.dto.SysUserDTO;
import net.moxuan.common.entity.SysUser;

/**
 * @author: moxuan
 * @description:
 */
public interface SysUserService {
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
     * 分页查询用户信息
     *
     * @param page 分页信息
     * @param queryWrapper 查询条件
     * @return IPage<SysUserDTO> 分页结果
     */
    IPage<SysUserDTO> page(IPage<SysUserDTO> page, Wrapper<SysUserDTO> queryWrapper);

    /**
     * 保存用户信息
     *
     * @param dto 用户信息
     * @return long 执行条数
     */
    long save(SysUserDTO dto);

    /**
     * 修改
     *
     *  @param dto 用户信息
     * @return int
     */
    int update(SysUserDTO dto);

    /**
     * 根据 id 查询用户信息
     *
     *  @param id 主键
     * @return SysOrg
     */
    SysUser queryById(String id);
}
