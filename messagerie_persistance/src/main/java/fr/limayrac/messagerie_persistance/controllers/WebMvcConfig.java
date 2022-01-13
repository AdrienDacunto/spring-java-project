package com.banque.persistance.controller;

 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {  
		registry.addViewController("/connexion").setViewName("connexionForm");
		registry.addViewController("/welcome").setViewName("welcome");
	}
}
