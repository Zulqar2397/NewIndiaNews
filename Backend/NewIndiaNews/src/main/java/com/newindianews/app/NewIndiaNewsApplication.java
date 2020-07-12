package com.newindianews.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewIndiaNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewIndiaNewsApplication.class, args);
		System.out.println("The Application is Up and Running");
	}

}
