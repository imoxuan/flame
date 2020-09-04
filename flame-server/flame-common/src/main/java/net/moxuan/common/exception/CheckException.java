package net.moxuan.common.exception;

import lombok.Getter;

/**
 * @author: moxuan
 * @description: 参数校验异常类
 */
@Getter
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1272965823863008480L;

    private Integer code;
    private String message;

    public CheckException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
