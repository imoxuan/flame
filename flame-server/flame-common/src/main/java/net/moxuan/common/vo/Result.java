package net.moxuan.common.vo;

import lombok.Data;
import net.moxuan.common.enums.ResultCode;

import java.io.Serializable;

/**
 * @author: moxuan
 * @description: 接口相应数据格式
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -2430016300084571102L;

    private Integer code;
    private String message;
    private T data;

    public Result() {
        this(ResultCode.SUCCESS);
    }
    public Result(ResultCode resultCode) {
        this.code = resultCode.code();
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success() {
        return new Result<>();
    }

    public static <T> Result<T> success(String message) {
        Result<T> r = new Result<>();
        r.setMessage(message);
        return r;
    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setData(data);
        return r;
    }

    public static <T> Result<T> fail(ResultCode resultCode) {
        return new Result<>(resultCode.code(), resultCode.message());
    }

}
