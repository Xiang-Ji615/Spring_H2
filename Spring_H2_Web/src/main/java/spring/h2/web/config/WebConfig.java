package main.java.spring.h2.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class WebConfig {

	@Bean
	public Gson getGson() {
		return new Gson();
	}
}
