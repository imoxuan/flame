package net.moxuan.utils;

import net.moxuan.constant.ErrorCodeConstant;
import net.moxuan.vo.Result;

/**
 * @author: moxuan
 * @description:
 */
public class ResultGenerator {

    private static final String SUCCESS = "执行成功";

    /**
     * 执行失败,自定义错误码、消息
     *
     * @param code 错误码
     * @param message 消息
     * @return <T> Result<T>
     */
    public static <T> Result<T> getFailResult(String code, String message) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    /**
     * 执行失败,自定义错误码、消息、数据
     *
     * @param code 错误码
     * @param message 消息
     * @param data 数据
     * @return <T> Result<T>
     */
    public static <T> Result<T> getFailResult(String code, String message, T data) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    /**
     * 执行成功, 默认消息
     *
     * @return <T> Result<T>
     */
    public static <T> Result<T> getSuccessResult() {
        Result<T> r = new Result<>();
        r.setCode(ErrorCodeConstant.SUCCESS);
        r.setMessage(SUCCESS);
        return r;
    }

    /**
     * 执行成功,自定义消息
     *
     * @param message 消息
     * @return <T> Result<T>
     */
    public static <T> Result<T> getSuccessResult(String message) {
        Result<T> r = new Result<>();
        r.setCode(ErrorCodeConstant.SUCCESS);
        r.setMessage(message);
        return r;
    }

    /**
     * 执行成功,自定义消息、数据
     *
     * @param message 消息
     * @param data 数据
     * @return <T> Result<T>
     */
    public static <T> Result<T> getSuccessResult(String message, T data) {
        Result<T> r = new Result<>();
        r.setCode(ErrorCodeConstant.SUCCESS);
        r.setMessage(message);
        r.setData(data);
        return r;
    }
}
