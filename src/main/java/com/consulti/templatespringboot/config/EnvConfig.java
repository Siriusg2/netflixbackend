package com.consulti.templatespringboot.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

  public EnvConfig() {
    Dotenv dotenv = Dotenv.configure().load();
    System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
    System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
    System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
    System.out.println(dotenv.get("DB_URL"));
  }
}
