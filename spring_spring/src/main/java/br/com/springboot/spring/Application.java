package br.com.springboot.spring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

@EnableJpaRepositories(basePackages="br.com.springboot.spring.repository")

@EntityScan(basePackages = "br.com.springboot.spring.model")


public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
