package com.skype.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.skype.bot.repositories")

@EnableTransactionManagement
public class SkypeBotApplication   {
	public static void main(String[] args) {
		SpringApplication.run(SkypeBotApplication.class, args);
	}

}
