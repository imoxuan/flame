package net.moxuan.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.admin.dto.SysUserDTO;
import net.moxuan.admin.service.SysUserService;
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
 * @description:
 */
@RequestMapping("/sys/user")
@RestController
public class SysUserController {
    @Resource
    private SysUserService userService;

    @GetMapping(value = "/list")
    @AutoLog(value = "分页查询用户信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public Result<?> queryPageList(SysUserDTO dto,
                                   @RequestParam(name = "pageNo", defaultValue = PageConst.DEFAULT_PAGE_NO) Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = PageConst.DEFAULT_PAGE_SIZE) Integer pageSize) {
        Page<SysUserDTO> page = new Page<>(pageNo, pageSize);
        IPage<SysUserDTO> pageList = userService.page(page, new QueryWrapper<>(dto));
        return Result.success(pageList);
    }

    @PostMapping(value = "/add")
    @AutoLog(value = "添加用户信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_ADD)
    public Result<String> add(@RequestBody @Validated SysUserDTO dto) {
        return Result.success(Long.toString(userService.save(dto)));
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody SysUserDTO dto) {
        return Result.success(userService.update(dto));
    }

    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(value = "ids") String ids) {
        return Result.success(userService.deleteBatch(ids));
    }

    @DeleteMapping(value = "/deleteById")
    public Result<?> deleteById(@RequestParam(value = "id") String id) {
        return Result.success(userService.deleteById(id));
    }
}
