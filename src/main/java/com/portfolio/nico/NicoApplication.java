package com.portfolio.nico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NicoApplication.class, args);
	}
        
}
