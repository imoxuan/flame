package net.moxuan.common.vo;

import lombok.Data;
import net.moxuan.common.enums.ResultCodeEnum;

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
        this(ResultCodeEnum.SUCCESS);
    }
    public Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.code();
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

    public static <T> Result<T> fail(ResultCodeEnum resultCodeEnum) {
        return new Result<>(resultCodeEnum.code(), resultCodeEnum.desc());
    }

}
