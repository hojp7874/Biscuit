package com.ssafy.a407;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class A407Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(A407Application.class, args);
	}

}
