package net.moxuan.common.aspect;

import net.moxuan.common.exception.CheckException;
import net.moxuan.common.vo.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: moxuan
 * @description:
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // TODO
        Result<String> r = new Result<>();
        r.setCode(2000);
        r.setMessage(objectError.getDefaultMessage());
        return r;
    }

    @ExceptionHandler(CheckException.class)
    public Result<?> checkExceptionHandler(CheckException e) {
        Result<String> r = new Result<>();
        r.setCode(e.getCode());
        r.setMessage(e.getMessage());
        return r;
    }
}
