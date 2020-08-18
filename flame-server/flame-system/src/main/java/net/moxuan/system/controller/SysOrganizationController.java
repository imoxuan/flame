package net.moxuan.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.moxuan.annotation.AutoLog;
import net.moxuan.constant.PageConst;
import net.moxuan.system.dto.SysOrganizationDTO;
import net.moxuan.system.entity.SysOrganization;
import net.moxuan.system.service.SysOrganizationService;
import net.moxuan.vo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @description: 集团信息访问接口
 */
@RequestMapping("/sys/org")
@RestController
public class SysOrganizationController {

    Logger logger = LoggerFactory.getLogger(SysOrganizationController.class);

    @Resource
    private SysOrganizationService organizationService;

    @GetMapping(value = "/list")
    @AutoLog(value = "集团信息分页查询", logType = 0)
    public ResultBean<?> queryPageList(SysOrganizationDTO dto,
                                       @RequestParam(name = "pageNo", defaultValue = PageConst.DEFAULT_PAGE_NO) Integer pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = PageConst.DEFAULT_PAGE_SIZE) Integer pageSize) {
        Page<SysOrganizationDTO> page = new Page<>(pageNo, pageSize);
        IPage<SysOrganizationDTO> pageList = organizationService.page(page, null);
        return new ResultBean<>(pageList);
    }

    @PostMapping(value = "/add")
    public ResultBean<Long> add(@RequestBody SysOrganization organization) {
        return new ResultBean<>(organizationService.save(organization));
    }

    @PutMapping(value = "/edit")
    public ResultBean<?> edit(@RequestBody SysOrganization organization) {
        return null;
    }

    @DeleteMapping(value = "/deleteBatch")
    public ResultBean<?> deleteBatch(String ids) {
        return null;
    }
}
