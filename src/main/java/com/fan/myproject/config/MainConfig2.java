package com.fan.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fan.myproject.bean.Person;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MainConfig2 {

    /**
     * ConfigurableBeanFactory.SCOPE_PROTOTYPE, prototype 多实例的
     * ConfigurableBeanFactory.SCOPE_SINGLETON, singleton单实例的（默认值）
     * org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST, request 同一次请求创建一个实例
     * org.springframework.web.context.WebApplicationContext.SCOPE_SESSION,session 同一个session创建一个实例
     *
     * 懒加载
     *  单实例bean，默认在容器启动的时候创建对象
     *  懒加载，容器启动不创建对象，使用的时候加载
     */
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person===");
        return new Person("张红",22);
    }
}
