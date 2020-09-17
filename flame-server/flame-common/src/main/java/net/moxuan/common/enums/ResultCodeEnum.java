package net.moxuan.common.enums;

/**
 * @author: moxuan
 * @description:
 */
public enum ResultCodeEnum {
    /**
     * 错误代码及描述, 格式：A-BB-CCC
     * A: 错误来源 1/2/3 1用户 2 系统 3 第三方
     * BB: 2 位，模块编号
     * CCCC: 最小1位，最大4位，自增即可。具体模块的错误提示
     *
     * 参数校验(@valid)错误码统一为100000
     */
    SUCCESS(0, "成功"),
    NAME_EXIST(1011, "名称已存在"),
    CODE_EXIST(1012, "编码已存在");
    /*ORG_NAME_MAX_LENGTH("A0102", "机构名称长度超过"),
    ORG_NAME_EXIST("A0103", "机构名称已存在"),
    ORG_CODE_EMPTY("A0104", "机构编码为空"),
    ORG_CODE_MAX_LENGTH("A01035", "机构编码长度"),
    ORG_CODE_EXIST("A0106", "机构名称已存在");*/

    private Integer code;
    private String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }

}
