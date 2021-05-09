package com.example.logistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author hexiaobo
 * @title: LogisticsApplication
 * @projectName logistics
 * @description: TODO
 * @date 2019/4/1715:39
 */
@SpringBootApplication
@MapperScan("com.example.logistics.mapper")
public class LogisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsApplication.class, args);
	}

}

