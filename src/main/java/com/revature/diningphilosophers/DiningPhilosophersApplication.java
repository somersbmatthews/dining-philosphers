package com.revature.diningphilosophers;

import jakarta.ws.rs.ApplicationPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;


@SpringBootApplication
public class DiningPhilosophersApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DiningPhilosophersApplication.class)
	//	SpringApplication
				.web(WebApplicationType.REACTIVE)
				.run(args);
	}

}
