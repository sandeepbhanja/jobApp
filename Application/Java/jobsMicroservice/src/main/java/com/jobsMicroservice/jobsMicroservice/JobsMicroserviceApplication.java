package com.jobsMicroservice.jobsMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JobsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsMicroserviceApplication.class, args);
	}

}
