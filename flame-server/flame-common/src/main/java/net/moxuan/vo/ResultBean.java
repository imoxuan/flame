package net.moxuan.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1053638558460971224L;

    public static final String SUCCESS = "00000";

    /*public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int CHECK_FAIL = 1;

    public static final int NO_PERMISSION = 2;

    public static final int UNKNOWN_EXCEPTION = -99;*/

    /**
     * 返回的信息(主要出错的时候使用)
     */
    private String message;

    /**
     * 接口返回码, 00000表示成功,99999 表示未知异常 其他看对应的定义
     */
    private String code = SUCCESS;

    /**
     * 返回的数据
     */
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        /*this.msg = e.toString();
        this.code = e.get*/
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
