package net.moxuan.controller;

import net.moxuan.entity.SysOrganization;
import net.moxuan.service.SysOrganizationService;
import net.moxuan.utils.ResultGenerator;
import net.moxuan.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description: 集团信息访问接口
 */
@RestController
@RequestMapping("/sys/org")
public class SysOrganizationController {

    Logger logger = LoggerFactory.getLogger(SysOrganizationController.class);

    @Resource
    private SysOrganizationService organizationService;

    @GetMapping(value = "/all")
    public List<SysOrganization> getList() {
        logger.info("Test");
        List<SysOrganization> list = new ArrayList<>();
        return list;
    }

    @PostMapping(value = "/add")
    public Result<SysOrganization> add(@RequestBody SysOrganization organization) {
        try {
            return organizationService.save(organization);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // TODO 错误码需要细致
            return ResultGenerator.getFailResult("aa", "保存失败");
        }
    }
}
