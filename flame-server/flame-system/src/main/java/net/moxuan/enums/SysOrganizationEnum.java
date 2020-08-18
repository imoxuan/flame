package net.moxuan.enums;

/**
 * @author: moxuan
 * @description: 错误代码枚举类
 */
public enum SysOrganizationEnum {
    /**
     * 机构名称为空
     */
    ORG_NAME_EMPTY("A0101", "集团名称为空"),
    /**
     * 机构名称已存在
     */
    ORG_NAME_LENGTH("A0102", "集团名称长度"),
    /**
     * 机构名称已存在
     */
    ORG_NAME_EXIST("A0103", "集团名称已存在"),
    /**
     * 机构编码已存在
     */
    ORG_CODE_EXIST("A0102", "集团编码已存在");

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String desc;

    SysOrganizationEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
