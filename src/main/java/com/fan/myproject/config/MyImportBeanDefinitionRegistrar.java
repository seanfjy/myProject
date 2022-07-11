package com.fan.myproject.config;

import com.fan.myproject.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata annotation metadata of the importing class 当前类的注解信息
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.fan.myproject.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.fan.myproject.bean.Blue");
        if (red && blue){
            //制定bean定义信息，（bean的类型，bean。。。）
            BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，只采用bean名
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
