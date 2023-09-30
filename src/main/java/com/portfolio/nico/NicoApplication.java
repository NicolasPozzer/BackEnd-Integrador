package com.portfolio.nico;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication
public class NicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NicoApplication.class, args);
	}
        
}*/
@SpringBootApplication(proxyBeanMethods = false)
public class NicoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(NicoApplication.class);
		String port = System.getenv("PORT");
		app.setDefaultProperties(Collections.singletonMap("server.port", port == null ? "8080" : port));
		app.run(args);
	}
}