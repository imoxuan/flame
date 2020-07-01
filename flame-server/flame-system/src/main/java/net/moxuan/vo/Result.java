package net.moxuan.vo;

import java.io.Serializable;

/**
 * @author: moxuan
 * @description: 接口返回数据格式
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1952751605653094316L;

    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public Result() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
