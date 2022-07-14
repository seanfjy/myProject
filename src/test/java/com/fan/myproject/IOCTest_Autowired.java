package com.fan.myproject;

import com.fan.myproject.bean.Boss;
import com.fan.myproject.bean.Car;
import com.fan.myproject.bean.Color;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fan.myproject.config.MainConfigOfAutowire;
import com.fan.myproject.service.BookService;

public class IOCTest_Autowired {
    @Test
    void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
        BookService bean = applicationContext.getBean(BookService.class);
        System.out.println(bean);

//        BookDao bean1 = applicationContext.getBean(BookDao.class);
//        System.out.println(bean1);

        Boss bean1 = applicationContext.getBean(Boss.class);
        System.out.println(bean1);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);
        Color bean2 = applicationContext.getBean(Color.class);
        System.out.println(bean2);

        System.out.println(applicationContext);

        applicationContext.close();
    }
}
