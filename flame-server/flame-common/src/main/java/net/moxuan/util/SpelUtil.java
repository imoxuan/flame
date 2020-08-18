package net.moxuan.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 *  spring 表达式 AOP 处理工具类
 *
 * @author  晓风轻 https://github.com/xwjie/PLMCodeTemplate
 */
public class SpelUtil {


    private final SpelExpressionParser parser;
    private final StandardEvaluationContext context;

    public SpelUtil(ProceedingJoinPoint pjp) {
        this.parser = new SpelExpressionParser();
        this.context = new StandardEvaluationContext();

        extractArgments(pjp);
    }

    /**
     *  得到参数名称和值 放到 spel 上下文
     * @param pjp 织点
     */
    private void extractArgments(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        String[] names   = methodSignature.getParameterNames();
        Object[] args = pjp.getArgs();

        for (int i = 0; i < names.length; i++) {
            this.context.setVariable(names[i], args[i]);
        }
    }

    /**
     * 计算表达式
     *
     * @param expr 表达式
     * @return object 对象
     */
    public Object cacl(String expr) {
        if (expr == null || expr.trim().isEmpty() ) {
            return null;
        }
        return this.parser.parseRaw(expr).getValue(this.context);
    }
}
