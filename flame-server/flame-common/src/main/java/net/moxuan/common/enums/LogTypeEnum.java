package net.moxuan.common.enums;

/**
 * @author: moxuan
 * @description:
 */
public enum LogTypeEnum implements EnumModel {
    /**
     * 日志类型枚举
     */
    LOGIN(0, "登录");

    private Integer code;
    private String desc;

    LogTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String desc() {
        return this.desc;
    }
}
