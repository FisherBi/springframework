package com.fisher.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by fisbii on 16-12-8.
 */
//指定切面的优先级，当有多个切面时，数值越小优先级越高
@Order(1)
@Aspect
public class LogAop {

    private Logger logger = Logger.getLogger(LogAop.class);

    @Pointcut("execution(* com.fisher.service.*.*(..))")
    public void log(){}

    @Around("log()")
    public Object printServiceLog(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        long start = System.currentTimeMillis();
        // 获得类名称
        String className = joinPoint.getTarget().getClass().getName();
        // 获得方法名称
        String methodName = joinPoint.getSignature().getName();
        try {
            logger.debug("-------------------------------------------------------------------------------------------------");
            logger.info("Invoking...  " + className + "." + methodName);
            obj = joinPoint.proceed();
            long end = System.currentTimeMillis();
            if (end - start > 100) {
                logger.info("------\t" + className + "." + methodName);
                logger.warn("timecost:处理时间(" + (end - start) + "ms):" + className + "." + methodName);
            }
        } catch (Throwable throwable) {
            logger.error("The service "+ className + "." + methodName +" failed to invoke!!!",throwable);
        }
        return obj;
    }
}
