package com.fan.myproject.config;

import com.fan.myproject.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//使用@PropertySource读取外部配置文件中的k/v保存在
@PropertySource(value = {"classpath:/person.properties"})
public class MainConfigOfPropert {

    @Bean
    public Person person(){
        return new Person();
    }
}
