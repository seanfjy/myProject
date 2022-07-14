package com.fan.myproject;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fan.myproject.aop.MathCalculator;
import com.fan.myproject.config.MainConfigOfAOP;
import com.fan.myproject.config.MainConfigOfProfile;

public class IOCTest_Profile_Aop {

    //1.使用命令行参数 再虚拟机参数位置加载 -Dspring-profiles.active=test
    //2.利用

    @Test
    void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("prod");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        applicationContext.close();
    }

    @Test
    void testaop(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(10,0);
    }
}
