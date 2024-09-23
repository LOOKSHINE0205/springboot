package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 2) 자동설정기능
class DemoApplication {
	// 스프링 부트의 시작 메서드 ...
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
