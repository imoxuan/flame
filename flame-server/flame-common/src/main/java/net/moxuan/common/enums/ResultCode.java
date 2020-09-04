package net.moxuan.common.enums;

/**
 * @author: moxuan
 * @description:
 */
public enum ResultCode {
    /**
     * 错误代码及描述
     */
    SUCCESS(0, "成功"),
    ORG_NAME_EXIST(1000, "机构已存在"),
    ORG_CODE_EXIST(1001, "机构编码已存在");
    /*ORG_NAME_MAX_LENGTH("A0102", "机构名称长度超过"),
    ORG_NAME_EXIST("A0103", "机构名称已存在"),
    ORG_CODE_EMPTY("A0104", "机构编码为空"),
    ORG_CODE_MAX_LENGTH("A01035", "机构编码长度"),
    ORG_CODE_EXIST("A0106", "机构名称已存在");*/

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
