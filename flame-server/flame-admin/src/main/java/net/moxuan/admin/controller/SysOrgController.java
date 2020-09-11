package net.moxuan.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.admin.service.SysOrgService;
import net.moxuan.common.annotation.AutoLog;
import net.moxuan.common.constant.LogConst;
import net.moxuan.common.constant.PageConst;
import net.moxuan.common.dto.SysOrgDTO;
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
 * @description: 机构信息访问接口
 */
@RequestMapping("/sys/org")
@RestController
public class SysOrgController {

    @Resource
    private SysOrgService orgService;

    @GetMapping(value = "/all")
    @AutoLog(value = "查询机构信息", logType = LogConst.LOG_TYPE_LOGIN, operateType = LogConst.ACTION_TYPE_QUERY)
    public Result<?> queryAll() {
        return Result.success(orgService.queryAll());
    }

    @GetMapping(value = "/list")
    @AutoLog(value = "分页查询机构信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public Result<?> queryPageList(SysOrgDTO dto,
                                   @RequestParam(name = "pageNo", defaultValue = PageConst.DEFAULT_PAGE_NO) Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = PageConst.DEFAULT_PAGE_SIZE) Integer pageSize) {
        Page<SysOrgDTO> page = new Page<>(pageNo, pageSize);
        IPage<SysOrgDTO> pageList = orgService.page(page, new QueryWrapper<>(dto));
        return Result.success(pageList);
    }

    @PostMapping(value = "/add")
    @AutoLog(value = "添加机构信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_ADD)
    public Result<String> add(@RequestBody @Validated SysOrgDTO organization) {
        return Result.success(Long.toString(orgService.save(organization)));
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody SysOrgDTO dto) {
        return Result.success(orgService.update(dto));
    }

    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(value = "ids") String ids) {
        return Result.success(orgService.deleteBatch(ids));
    }

    @DeleteMapping(value = "/deleteById")
    public Result<?> deleteById(@RequestParam(value = "id") String id) {
        return Result.success(orgService.deleteById(id));
    }
}
