package net.moxuan.admin.controller;

import net.moxuan.admin.dto.SysDictItemDTO;
import net.moxuan.admin.service.SysDictItemService;
import net.moxuan.common.annotation.AutoLog;
import net.moxuan.common.constant.LogConst;
import net.moxuan.common.vo.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: moxuan
 * @description: 字典信息访问接口
 */
@RequestMapping("/sys/dictItem")
@RestController
public class SysDictItemController {

    @Resource
    private SysDictItemService dictItemService;

    @GetMapping(value = "/list")
    @AutoLog(value = "查询字典项信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public Result<?> queryList(SysDictItemDTO dto) {
        return Result.success(dictItemService.queryList(true, dto));
    }

    @PostMapping(value = "/add")
    @AutoLog(value = "添加字典项信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_ADD)
    public Result<String> add(@RequestBody @Validated SysDictItemDTO dto) {
        return Result.success(Long.toString(dictItemService.save(dto)));
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody SysDictItemDTO dto) {
        return Result.success(dictItemService.update(dto));
    }

    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(value = "ids") String ids) {
        return Result.success(dictItemService.deleteBatch(ids));
    }

    @DeleteMapping(value = "/deleteById")
    public Result<?> deleteById(@RequestParam(value = "id") String id) {
        return Result.success(dictItemService.deleteById(id));
    }
}
