package net.moxuan.enums;

/**
 * @author: moxuan
 * @description:
 */
public enum LogTypeEnum {
    /**
     * 登录日志
     */
    LOGIN(1, "登录"),
    OPERATION(2, "操作"),
    CORN_JOB(3, "定时任务");

    /**
     * 编码
     */
    private final int code;
    /**
     * 描述
     */
    private final String desc;

    LogTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
