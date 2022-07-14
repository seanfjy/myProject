package com.fan.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fan.myproject.aop.LogAspects;
import com.fan.myproject.aop.MathCalculator;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP 指在程序运行期间动态的将某段代码切入到指定方法指定位置进行的编程方式
 *
 * 1.导入AOP 模块；Spring SAOP (spring-aspects)
 * 2.定义一个业务逻辑类MathCalculator，在业务逻辑运行的时候将日志进行打印
 * 3.定义一个日志切面类LogAspects ：切面类理面 的方法需要动态感知MathCalculator。div运行
 *      通知方法：
 *          前置通知(@Before) 在目标方法之前运行
 *          后置通知(@After) 在目标方法之后
 *          返回通知(@AfterReturning) 在目标方法正常返回之后运行
 *          异常通知(@AfterThrowing) 在目标方法出现异常以后运行
 *          环绕通知(@Around) 动态代理，手动推进目标放放松运行（joinPoint.proceed())
 *4.给切面类的方法标注何时何地运行(通知注解）
 * 5.将切面类好业务逻辑类（目标方法所在类）都加入到容器中
 * 6（给切面类加个注解@Aspect，告诉spring当前类为切面类
 * 7、给配置类中加@EnableAspectJAutoProxy//开启基于注解的aop模式
 */
@EnableAspectJAutoProxy//开启基于注解的aop模式
@Configuration
public class MainConfigOfAOP {
    //业务逻辑类加入容器中
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }
    //切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
