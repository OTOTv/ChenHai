package com.hrdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hrdemo.*"})
@MapperScan("com.hrdemo.dao")
public class ChrdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChrdemoApplication.class, args);
	}

}
