package com.fan.myproject.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFacotryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFacotryPostProcessor.. "+beanFactory);
        int beanPostProcessorCount = beanFactory.getBeanPostProcessorCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("容器中有："+beanPostProcessorCount+"个bean");
        System.out.println(Arrays.asList(beanDefinitionNames));

    }
}
