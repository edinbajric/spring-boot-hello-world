package com.task1.springboothelloworld;

import com.task1.springboothelloworld.controller.DatabaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
		DatabaseController printHW = new DatabaseController(null);

		System.out.println(printHW.printHelloWorld());
	}
}
