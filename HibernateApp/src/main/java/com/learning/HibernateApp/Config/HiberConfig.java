package com.learning.HibernateApp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.learning.HibernateApp" )

public class HiberConfig 
{
	@Bean
	public InternalResourceViewResolver getResolverObj()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/Views/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}
	
}
