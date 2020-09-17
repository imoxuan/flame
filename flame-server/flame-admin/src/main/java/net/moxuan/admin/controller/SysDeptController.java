package net.moxuan.admin.controller;

import net.moxuan.admin.service.SysDeptService;
import net.moxuan.common.annotation.AutoLog;
import net.moxuan.common.constant.LogConst;
import net.moxuan.admin.dto.DeptTreeDTO;
import net.moxuan.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */
@RequestMapping("/sys/dept")
@RestController
public class SysDeptController {

    @Resource
    private SysDeptService deptService;

    @GetMapping(value = "/tree")
    @AutoLog(value = "查询机构信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public Result<?> queryAll(@RequestParam("orgId") String orgId) {
        List<DeptTreeDTO> list = deptService.queryDeptTree(orgId);
        return Result.success(list);
    }
}
