package com.task1.springboothelloworld;

import com.task1.springboothelloworld.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
		Controller printHW = new Controller();

		System.out.println(printHW.PrintHelloWorld());

	}
}