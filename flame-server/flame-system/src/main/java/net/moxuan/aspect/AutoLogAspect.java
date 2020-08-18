package net.moxuan.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.moxuan.annotation.AutoLog;
import net.moxuan.system.entity.SysLog;
import net.moxuan.system.service.SysLogService;
import net.moxuan.util.SpelUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: moxuan
 * @description:
 */
public class AutoLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(AutoLogAspect.class);

    @Resource
    private SysLogService sysLogService;

    public static final String JSON_KEY = "logJson";

    public Object handlerLogMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        Object result = null;

        try {
            putLogInfo2MDC(pjp);
            result = pjp.proceed();

            // 本次操作用时（毫秒）
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("[{}]use time: {}", pjp.getSignature(), elapsedTime);
            
            saveLog(pjp, elapsedTime);
        } catch (Throwable t) {
            logger.error("errorMessage:{}", t.getMessage(), t);
        } finally {
            clearMDC();
        }

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        SysLog sysLog = new SysLog();
        sysLog.setElapsedTime(time);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = signature.getName();
        String className = joinPoint.getTarget().getClass().getName();
        sysLog.setMethod(className + "." + methodName + "()");

        AutoLog autoLog = method.getAnnotation(AutoLog.class);
        if(autoLog != null){
            //注解上的描述,操作日志内容
            sysLog.setContent(autoLog.value());
            sysLog.setLogType(autoLog.logType());
        }
        
        Object[] args = joinPoint.getArgs();

        sysLogService.save(sysLog);
    }

    private void clearMDC() {
        MDC.remove(JSON_KEY);
    }

    private void putLogInfo2MDC(ProceedingJoinPoint pjp) throws JsonProcessingException {
        // 得到方法上的注解
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        AutoLog autoLog = signature.getMethod().getAnnotation(AutoLog.class);


        SpelUtil spel = new SpelUtil(pjp);

        Map<String, Object> map = new HashMap<>(5);
        // 使用单字母而不是全名，是为了节省日志文件大小。
        // TODO 用户
        // map.put("U", UserUtil.getUserIfLogin());
        // 操作
        // map.put("A", logAnnotation.action());

        // 对象类型
        // map.put("T", logAnnotation.itemType());

        // 对象id，spel表达式
        // map.put("I", spel.cacl(logAnnotation.itemId()));

        // 其他参数，spel表达式
        // map.put("P", spel.cacl(logAnnotation.param()));

        // ObjectMapper mapper = new ObjectMapper();

        // MDC.put(JSON_KEY, mapper.writeValueAsString(map));
    }
}
