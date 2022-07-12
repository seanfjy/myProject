package com.fan.myproject;

import com.fan.myproject.bean.Person;
import com.fan.myproject.config.MainConfigOfPropert;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fan.myproject.config.MainConfigOfLifeCycle;
import org.springframework.core.env.ConfigurableEnvironment;

public class IocTest {

    @Test
    void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
//        Car bean = applicationContext.getBean(Car.class);
//        Car bean2 = applicationContext.getBean(Car.class)`;
//        System.out.println(bean2==bean);
        applicationContext.close();
        System.out.println("容器关闭");
    }
    @Test
    void test2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropert.class);
        printBeans(applicationContext);
        System.out.println("===========");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }


    private static void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
