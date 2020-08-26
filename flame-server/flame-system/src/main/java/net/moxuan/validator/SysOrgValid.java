package net.moxuan.validator;

import net.moxuan.constant.ErrorCodeConst;
import net.moxuan.system.dto.SysOrgDTO;
import net.moxuan.util.CheckUtil;
import net.moxuan.util.StringUtil;

/**
 * @author: moxuan
 * @description: 机构类校验
 */
public class SysOrgValid {

    private static final int ORG_NAME_MAX_LENGTH = 30;
    private static final int ORG_CODE_MAX_LENGTH = 10;

    public static void valid(SysOrgDTO dto) {
        String name = dto.getName();
        CheckUtil.notEmpty(name, ErrorCodeConst.ORG_NAME_EMPTY,"机构名称为空");
        CheckUtil.maxLength(name, ORG_NAME_MAX_LENGTH, ErrorCodeConst.ORG_NAME_MAX_LENGTH, "机构名称长度超过 " + ORG_NAME_MAX_LENGTH);

        String code = dto.getCode();
        CheckUtil.notEmpty(code, ErrorCodeConst.ORG_CODE_EMPTY,"机构编码为空");
        CheckUtil.maxLength(code, ORG_CODE_MAX_LENGTH, ErrorCodeConst.ORG_CODE_MAX_LENGTH, "机构编码长度超过 " + ORG_CODE_MAX_LENGTH);

        if (dto.getSortNo() == null || !StringUtil.isNumber(String.valueOf(dto.getSortNo()))) {
            dto.setSortNo(1);
        }
    }

}
