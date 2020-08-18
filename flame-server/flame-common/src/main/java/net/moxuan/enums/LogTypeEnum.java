package net.moxuan.enums;

/**
 * @author: moxuan
 * @description:
 */
public enum LogTypeEnum {
    /**
     * 错误描述操作日志;1:登录日志;2:定时任务
     */
    OPERATION(0, "operate");

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误描述
     */
    private String desc;

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
