package net.moxuan.common.enums;

/**
 * @author: moxuan
 * @description:
 */
public enum OperationTypeEnum {

    /**
     * 登录日志
     */
    ADD(1, "添加"),
    UPDATE(2, "更新"),
    DELETE(3, "删除"),
    QUERY(4, "查询"),
    IMPORT(5, "导入"),
    EXPORT(6, "导出");

    /**
     * 编码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    OperationTypeEnum(int code, String desc) {
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
