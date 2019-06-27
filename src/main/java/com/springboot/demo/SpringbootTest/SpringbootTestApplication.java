package com.springboot.demo.SpringbootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringbootTestApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}

	@GetMapping(path = "test")
	public String test(){
		return "hello";
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(SpringbootTestApplication.class);

		return builder;
	}
}
