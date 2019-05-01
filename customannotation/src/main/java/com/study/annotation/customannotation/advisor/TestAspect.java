package com.study.annotation.customannotation.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    //设置切入点
    @Pointcut("execution(public * com.study.annotation.customannotation.controller.HelloController.add*(..))&&@annotation(com.study.annotation.customannotation.MyAnnotation)")
    public void addAdvice(){}

    @Around("addAdvice()")
    public Object interceptor(ProceedingJoinPoint pjp){
        Object result =null;    //切入点执行结果
        Object[] args = pjp.getArgs();
        if (args != null&&args.length>0) {
            String deviceId = (String) args[0];
            if (!"03".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
