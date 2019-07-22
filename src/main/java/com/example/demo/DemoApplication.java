package com.example.demo;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@SuppressWarnings("deprecation")
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory=new MultipartConfigFactory();
		factory.setMaxFileSize("100MB");
		factory.setMaxRequestSize("100MB");
		return factory.createMultipartConfig();
	}
}

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) 
//public class DemoApplication {
//
//public static void main(String[] args) {  
//    SpringApplication.run(DemoApplication.class, args);  
//	}
//}

