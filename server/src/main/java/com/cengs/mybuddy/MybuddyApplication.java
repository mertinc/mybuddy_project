package com.cengs.mybuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan()
public class MybuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybuddyApplication.class, args);
		System.out.println("App working");
	}
}
	