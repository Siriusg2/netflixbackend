package com.consulti.templatespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateSpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(TemplateSpringbootApplication.class, args);
    System.out.println("Server listening on port 5000");
  }
}
