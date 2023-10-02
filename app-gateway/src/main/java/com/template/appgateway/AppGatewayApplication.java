package com.template.appgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AppGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppGatewayApplication.class, args);
	}
}
