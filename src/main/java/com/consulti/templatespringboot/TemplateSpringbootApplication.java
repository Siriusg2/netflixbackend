package com.consulti.templatespringboot;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Import;

import com.consulti.templatespringboot.config.CorsConfig;



@SpringBootApplication
@Import(CorsConfig.class)

public class TemplateSpringbootApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(TemplateSpringbootApplication.class, args);
		System.out.println("server listening on port 5000" );
		
	}

}
