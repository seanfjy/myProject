package com.fan.myproject;

import com.fan.myproject.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fan.myproject.bean.Person;
import com.fan.myproject.config.MainConfig;

import lombok.val;

@SpringBootTest
class MyProjectApplicationTests {

    @Test
    void contextLoads() {
        val applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
    @Test
    void contextLoads1(){

        var applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    void contextLoads2(){
        var applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    void test1(){
        var applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);
        }
        System.out.println("创建ioc容器完成，准备获取实例====");
        Object person = applicationContext.getBean("person");
//        Object person2 = applicationContext.getBean("person");

//        System.out.println(person==person2);

    }
}
