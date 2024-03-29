package com.manikanta.microservices.project.OrderService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {
	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
