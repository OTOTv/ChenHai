package com.hrdemo.shiro.config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by OTOT on 2019/5/24.
 */
public class MyTest {
    @Test
    public void xx(){
        ApplicationContext context;
        context=new AnnotationConfigApplicationContext(CarBean.class);
       Car car= (Car) context.getBean("car");
        System.out.println(car.getName());
    }
}
