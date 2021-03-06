package net.moxuan.admin.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.moxuan.admin.dto.SysDictDTO;

import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
public interface SysDictService {

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
     * 根据编码查询记录数
     *
     * @param code 编码
     * @return int
     */
    int queryByCode(String code);

    /**
     * 分页查询字典信息
     *
     * @param page 分页信息
     * @param queryWrapper 查询条件
     * @return IPage<SysDictDTO> 分页结果
     */
    IPage<SysDictDTO> page(IPage<SysDictDTO> page, Wrapper<SysDictDTO> queryWrapper);

    /**
     * 查询全部字典信息
     *
     * @param enabled 是否包含不可用的
     * @return IPage<SysDictDTO> 分页结果
     */
    List<SysDictDTO> queryList(boolean enabled);

    /**
     * 保存字典信息
     *
     * @param dto 字典信息
     * @return long 执行条数
     */
    long save(SysDictDTO dto);

    /**
     * 修改
     *
     *  @param dto 字典信息
     * @return int
     */
    int update(SysDictDTO dto);
}
