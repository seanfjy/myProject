package com.fan.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fan.myproject.bean.Car;
import com.fan.myproject.bean.Color;
import com.fan.myproject.dao.BookDao;

/**
 * 自动装配：
 *         Spring利用依赖注入（DI），完成对IOC容器中各个主键的依赖关系赋值
 *   1》 @Autowired 自动注入  Spring定义的
 *      1）默认优先按照类型去容器中找对应的组件 pplicationContext.getBean(BookDao.class)
 *      2)如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *      applicationContext.getBean(“bookDao2”)
 *      3)@Qualifier("bookDao") 可以指定装配的bean
 *      4)自动装配默认一定要将属性赋值好，没有就会报错
 *      可使用    @Autowired(required = false)
 *      5）    @Primary :让Spring进行自动装配的时候，默认使用首选的bean
 *              也可以继续使用@Qualifier("bookDao") 可以指定装配的bean
 *
 *   2.Spring 还支持使用@Resource(JSR250)和@Inject(JSR330) [java规范的注解]
 *      1）@Resource:
 *          可以和@Autowired一样自动装配，但其使用的是属组件名称进行装配的
 *          没有能支持@Primary功能，没有支持@Autowired（required=false）
 *      2）@Inject
 *      需要导入javax.inject的包和Autowired的功能一样，没有required=false
 *
 *   3. @Autowired 构造器，参数，方法，属性，都是从容器中获取参数组件的值
 *          1）【标注再方法位置】 @bean+方法参数，参数从容器中获取；默认不写@Autowired也能自动装配
 *          2）【标注在构造器】上，如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件从容器中获取
 *          3）放在参数位置，
 *
 *  4，自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx
 *          自定义镞实现xxxAware,在创建对象的时候 ，会调用接口规定的方法注入相关组件  Aware
 */
@Configuration
@ComponentScan(value = {"com.fan.myproject.controller","com.fan.myproject.dao","com.fan.myproject.service","com.fan.myproject.bean"})
public class MainConfigOfAutowire {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
