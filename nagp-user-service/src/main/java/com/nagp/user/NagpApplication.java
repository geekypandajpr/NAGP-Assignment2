package com.nagp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NagpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NagpApplication.class, args);
	}
}
