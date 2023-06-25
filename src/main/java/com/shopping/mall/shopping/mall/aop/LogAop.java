package com.shopping.mall.shopping.mall.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.security.CodeSigner;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(* com.shopping.mall.shopping.mall.api.*API.*(..))")
    private void pointCut() {}

    @Pointcut("annotation(com. shopping.mall.shopping.mall.aop.annotation.LogAspect)")
    private void annotionPointCut() {}

    @Around("annotionPoinCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        for(int i = 0; i < parameterNames.length; i++) {
            log.info("<<<< Parameter Info >>>> {}.{} >>> [{}: {}]", className, methodName, parameterNames[i], args[i]);
        }

        Object result = joinPoint.proceed();

        log.info("<<<< return >>>> {}.{} >>> [{}]", className, methodName, result);

        return result;

    }


}
