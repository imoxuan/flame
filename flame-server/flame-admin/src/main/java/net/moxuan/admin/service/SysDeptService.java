package net.moxuan.admin.service;

import net.moxuan.admin.dto.DeptTreeDTO;
import net.moxuan.admin.dto.SysDeptDTO;

import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
public interface SysDeptService {

    /**
     * 根据名称查询记录数
     *
     * @param name 名称
     * @return int
     */
    int queryByName(String name);

    /**
     * 保存部门信息
     *
     * @param dto 部门信息
     * @return long 执行条数
     */
    int save(SysDeptDTO dto);

    /**
     * 部门数信息
     *
     * @param orgId 机构id
     * @return List<DeptTreeDTO>
     */
    List<DeptTreeDTO> queryDeptTree(String orgId);
}
