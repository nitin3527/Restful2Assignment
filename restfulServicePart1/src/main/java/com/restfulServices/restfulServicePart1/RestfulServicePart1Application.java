package com.restfulServices.restfulServicePart1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulServicePart1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServicePart1Application.class, args);
	}

	@Bean
	public AcceptHeaderLocaleResolver localResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

}
