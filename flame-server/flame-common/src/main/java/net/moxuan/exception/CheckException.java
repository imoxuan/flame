package net.moxuan.exception;

/**
 * @author: moxuan
 * @description: 参数校验异常类
 */
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1272965823863008480L;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CheckException(String code, String message) {
        super(message);
        this.code = code;
    }

}
