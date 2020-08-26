package net.moxuan.aspect;

import net.moxuan.exception.CheckException;
import net.moxuan.exception.UnloginException;
import net.moxuan.vo.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NoPermissionException;

/**
 * @author: moxuan
 * @description:
 */
public class ControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("[{}]use time: {}", pjp.getSignature(), elapsedTime);
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean<>();

        // 已知异常【注意：已知异常不要打印堆栈，否则会干扰日志】
        // 校验出错，参数非法
        if (e instanceof CheckException) {
            CheckException checkException = (CheckException) e;
            result.setCode(checkException.getCode());
            result.setMessage(checkException.getMessage());
        }
        // 没有登陆
        else if (e instanceof UnloginException) {
        }
        // 没有权限
        else if (e instanceof NoPermissionException) {
        } else {
            logger.error(pjp.getSignature() + " error {}", e.getMessage());
        }
        return result;
    }
}
