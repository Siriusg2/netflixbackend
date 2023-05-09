package com.consulti.templatespringboot;

import javax.sound.sampled.Port;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TemplateSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateSpringbootApplication.class, args);
		System.out.println("server listening on port 5000" );

	}

}
