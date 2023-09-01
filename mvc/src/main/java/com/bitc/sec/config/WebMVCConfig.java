package com.bitc.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// web.xml 을 대신 또는 보충 하는 class 
// WebMvcConfigurer

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		/*registry.addResourceHandler("/upload/**").addResourceLocations("/upload/");*/
	}

	@Bean 
	public String uploadPath() {
		return "upload";
	}
}










