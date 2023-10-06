package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@ComponentScan(basePackages= {"com.example.*"})


public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	public void run(String... args) throws Exception {
		System.out.println("passer");
	}

}
