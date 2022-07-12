package com.fan.myproject.config;

import com.fan.myproject.bean.Color;
import com.fan.myproject.bean.ColorFactoryBean;
import com.fan.myproject.bean.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.fan.myproject.bean.Person;
import com.fan.myproject.condition.LinuxCondition;
import com.fan.myproject.condition.WindowsCondition;

@Configuration
@Conditional({WindowsCondition.class})
@Import({Color.class, Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//快速导入组件，id默认为组件全类名
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
        return new Person("张红",22,null);
    }
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",66,null);
    }
    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person02(){
        return new Person("Linus",77,null);
    }

    /**
     *给容器中注册组件：
     * 1.包扫描+组件标注注解（@Controller,@Service,@Repository,@Component
     * 2.@Bean【导入的第三方包里面的组件】
     * 3.@Import[快速给容器中导入一个组件]
     *  1）@Import(要导入到容器中的组件），容器中就会自动注册这个组件，id默认是全类名
     *  2）ImportSelector:返回需要导入的组件的全类名数组
     *  3）ImportBeanDefinitionRegistrar ：手动注册bean到容器
     * 4.使用Spring提供FactoryBean(工厂bean）
     *      1.默认获取到的是工厂bean动用getObject创建的对象
     *      2.要获取工厂Bean本身，我们需要给id前面加一个&标识
     *
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
