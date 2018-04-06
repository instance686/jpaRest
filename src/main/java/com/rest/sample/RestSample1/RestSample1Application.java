package com.rest.sample.RestSample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan({"com.rest.sample.RestSample1"})
@EnableJpaAuditing
public class RestSample1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestSample1Application.class, args);
	}
}
