package net.moxuan.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.admin.dto.SysDictDTO;
import net.moxuan.admin.service.SysDictService;
import net.moxuan.common.annotation.AutoLog;
import net.moxuan.common.constant.LogConst;
import net.moxuan.common.constant.PageConst;
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
@RequestMapping("/sys/dict")
@RestController
public class SysDictController {

    @Resource
    private SysDictService dictService;

    @GetMapping(value = "/list")
    @AutoLog(value = "分页查询字典信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public Result<?> queryPageList(SysDictDTO dto,
                                   @RequestParam(name = "pageNo", defaultValue = PageConst.DEFAULT_PAGE_NO) Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = PageConst.DEFAULT_PAGE_SIZE) Integer pageSize) {
        Page<SysDictDTO> page = new Page<>(pageNo, pageSize);
        IPage<SysDictDTO> pageList = dictService.page(page, new QueryWrapper<>(dto));
        return Result.success(pageList);
    }

    @PostMapping(value = "/add")
    @AutoLog(value = "添加字典信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_ADD)
    public Result<String> add(@RequestBody @Validated SysDictDTO dict) {
        return Result.success(Long.toString(dictService.save(dict)));
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody SysDictDTO dto) {
        return Result.success(dictService.update(dto));
    }

    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(value = "ids") String ids) {
        return Result.success(dictService.deleteBatch(ids));
    }

    @DeleteMapping(value = "/deleteById")
    public Result<?> deleteById(@RequestParam(value = "id") String id) {
        return Result.success(dictService.deleteById(id));
    }
}
