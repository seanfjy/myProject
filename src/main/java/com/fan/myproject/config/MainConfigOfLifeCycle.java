package com.fan.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fan.myproject.bean.Car;

/**
 * bean创建--初始化---销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *      单实例bean 创建容器的时候初始化，关闭容器的时候销毁
 *      多实例bean 只有在创建对象完成并复制好的时候才进调用初始化方法，关闭容器的时候不会调用销毁方法
 *
 *
 * 1》制定初始化和销毁方法：F
 *      指定init-method和destroy-method
*  2. 通过让Bean实例InitializingBean(定义初始化逻辑），DisposableBean(定义销毁逻辑）
 *  3.可以使用JSR250：
 *  @PostConstruct 在bean创建完成并且属性赋值完成，来执行初始化方法
 * @PreDestroy 在容器销毁bean之前通知我们进行清理工作
 * 4. BeanPostProcessor接口 bean的后置处理器
 *在bean初始化前后进行一些处理工作
 *  postProcessBeforeInitialization
 *  postProcessAfterInitialization
 *
 *  Spring底层对BeanPostProcessor的使用
 *          bean赋值，注入其它组件，@Autowired 生命周期注解功能 @Async，xxx BeanPostProcessor
 *
 *
 */
@Configuration
@ComponentScan("com.fan.myproject.bean")
public class MainConfigOfLifeCycle {


    @Bean(initMethod = "init",destroyMethod = "destroy")
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Car car(){
        return new Car();
    }

}
