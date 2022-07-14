package com.fan.myproject.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect//告诉spring当前类为切面类
public class LogAspects {
    //抽取公共的切入点表达式
    //1.本类引用
    //2.其他的切面引用
    @Pointcut("execution(public int com.fan.myproject.aop.MathCalculator.*(..))")
    public void pointCut(){};

    //在目标方法之前切入：切入点表达式（指定在那个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。。@Before，参数："+ Arrays.asList(args));
    }
    @After("com.fan.myproject.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"除法结束");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){//JoinPoint joinPoint 必须为参数的第一位
        System.out.println(joinPoint.getSignature().getName()+"除法正常返回。。。，运行结果；{" +result+
                "}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"除法异常。。。异常信息：{" +exception+
                "}");
    }
}
