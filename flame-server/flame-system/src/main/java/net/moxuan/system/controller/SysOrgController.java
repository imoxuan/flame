package net.moxuan.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.annotation.AutoLog;
import net.moxuan.constant.LogConst;
import net.moxuan.constant.PageConst;
import net.moxuan.system.dto.SysOrgDTO;
import net.moxuan.system.service.SysOrgService;
import net.moxuan.vo.ResultBean;
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
    @AutoLog(value = "查询机构信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public ResultBean<?> queryAll() {
        return new ResultBean<>(orgService.queryAll());
    }

    @GetMapping(value = "/list")
    @AutoLog(value = "分页查询机构信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_QUERY)
    public ResultBean<?> queryPageList(SysOrgDTO dto,
                                       @RequestParam(name = "pageNo", defaultValue = PageConst.DEFAULT_PAGE_NO) Integer pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = PageConst.DEFAULT_PAGE_SIZE) Integer pageSize) {
        Page<SysOrgDTO> page = new Page<>(pageNo, pageSize);
        IPage<SysOrgDTO> pageList = orgService.page(page, new QueryWrapper<>(dto));
        return new ResultBean<>(pageList);
    }

    @PostMapping(value = "/add")
    @AutoLog(value = "添加机构信息", logType = LogConst.LOG_TYPE_OPERATION, operateType = LogConst.ACTION_TYPE_ADD)
    public ResultBean<Long> add(@RequestBody SysOrgDTO organization) {
        return new ResultBean<>(orgService.save(organization));
    }

    @PutMapping(value = "/edit")
    public ResultBean<?> edit(@RequestBody SysOrgDTO dto) {
        return new ResultBean<>(orgService.update(dto));
    }

    @DeleteMapping(value = "/deleteBatch")
    public ResultBean<?> deleteBatch(String ids) {
        return new ResultBean<>(orgService.deleteBatch(ids));
    }

    @DeleteMapping(value = "/deleteById")
    public ResultBean<?> deleteById(String id) {
        return new ResultBean<>(orgService.deleteById(id));
    }
}
