package com.consulti.templatespringboot;

import com.consulti.templatespringboot.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class TemplateSpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(TemplateSpringbootApplication.class, args);
    System.out.println("server listening on port 5000");
  }
}
