package net.moxuan.enums;

/**
 * @author: moxuan
 * @description: 错误代码枚举类
 */
public enum CodeEnum {
    /**
     * 机构名称已存在
     */
    ORG_NAME_EXIST("A0101", "集团名称已存在"),
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

    CodeEnum(String code, String desc) {
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
