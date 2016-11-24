package com.skype.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SkypeBotApplication {
	@RequestMapping("/")
	public String greeting() {
		return "Hello docker";
	}
	public static void main(String[] args) {
		SpringApplication.run(SkypeBotApplication.class, args);
	}
}
