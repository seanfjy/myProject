package com.fan.myproject.ext;

import com.fan.myproject.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理:
 * BeanPostProcessor,bean后置处理器，bean创建对象初始化前后进行拦截工作
 * BeanFactoryPostProcessor beanFactory的后置处理器
 *          在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载到beanFatory，但是bean的实例还没创建
 *BeanFactoryPostProcessor原理：
 * 1）ioc容器创建对象
 *2)
 *
 */
@ComponentScan("com.fan.myproject.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
