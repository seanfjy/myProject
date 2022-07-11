package com.fan.myproject;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.fan.myproject.bean.Blue;
import com.fan.myproject.bean.Person;
import com.fan.myproject.config.MainConfig;
import com.fan.myproject.config.MainConfig2;

import lombok.val;

@SpringBootTest()
class MyProjectApplicationTests {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    void contextLoads() {
        val applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);
    }

    @Test
    void contextLoads1() {

        var applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    void contextLoads2() {
        var applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    void test1() {
        var applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);
        }
        System.out.println("创建ioc容器完成，准备获取实例====");
        Object person = applicationContext.getBean("person");
        // Object person2 = applicationContext.getBean("person");

        // System.out.println(person==person2);

    }

    @Test
    void test2() {
        var applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        // 动态获取环境变量
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);

    }

    @Test
    void test3() {
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型："+colorFactoryBean.getClass());
        System.out.println(colorFactoryBean==colorFactoryBean2);
        Object bean1 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean1.getClass());
    }

    private static void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
