package com.fan.myproject.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.fan.myproject.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile: Spring为我们提供的可以根据当前环境，动态的激活或切换一系列组件的功能
 *
 * @Profile: 指定组件再那个环境的情况下注册到容器中，不指定，在任何环境下都能注册这个组件
 *      加了环境标识的bean只有环境被激活时才注册到容器中
 */
@Configuration
//@Profile("test")//控制整个配置类
@PropertySource(value = {"classpath:/dbconfig.properties"})
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;

    private String driverClass;

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://192.168.19.130:3306/test");
        return dataSource;

    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://192.168.19.130:3306/mysql");
        return dataSource;

    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);

        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://192.168.19.130:3306/sys");
        return dataSource;

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("${db.driverClass}");
        this.driverClass = s;
    }
}
