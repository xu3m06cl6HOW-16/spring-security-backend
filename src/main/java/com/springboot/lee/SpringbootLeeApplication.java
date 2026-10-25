package com.springboot.lee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.lee.mapper")
public class SpringbootLeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLeeApplication.class, args);
	}

}
