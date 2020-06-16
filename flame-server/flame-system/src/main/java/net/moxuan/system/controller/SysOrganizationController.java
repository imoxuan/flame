package net.moxuan.system.controller;

import net.moxuan.system.entity.SysOrganization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description: 集团信息访问接口
 */
@RestController
@RequestMapping("/sys")
public class SysOrganizationController {

    @GetMapping("/all")
    public List<SysOrganization> getList() {
        List<SysOrganization> list = new ArrayList<>();
        return list;
    }
}
