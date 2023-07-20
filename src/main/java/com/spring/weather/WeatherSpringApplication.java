package com.spring.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WeatherSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSpringApplication.class, args);
	}

}
