package net.moxuan.common.vo;

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
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
