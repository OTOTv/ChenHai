package com.hrdemo.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by OTOT on 2019/5/24.
 */
@Configuration
public class CarBean {
    @Bean
    public Car car(){
        Car car=new Car();
        car.setName("尺寸");
        return car;
    }
}
