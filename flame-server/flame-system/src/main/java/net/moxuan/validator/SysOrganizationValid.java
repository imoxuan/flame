package net.moxuan.validator;

import net.moxuan.enums.SysOrganizationEnum;
import net.moxuan.system.entity.SysOrganization;
import net.moxuan.util.CheckUtil;

/**
 * @author: moxuan
 * @description: 集团类校验
 */
public class SysOrganizationValid {

    public static void valid(SysOrganization org) {
        String name = org.getName();
        CheckUtil.notEmpty(name, SysOrganizationEnum.ORG_NAME_EMPTY.getCode(), SysOrganizationEnum.ORG_NAME_EMPTY.getDesc());
    }

}
