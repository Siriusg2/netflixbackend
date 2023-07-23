package com.consulti.templatespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateSpringbootApplication {

  /**
   * Main method to run the Spring Boot application.
   *
   * @param args The command line arguments passed to the application.
   */
  public static void main(String[] args) {
    // Run the Spring Boot application
    SpringApplication.run(TemplateSpringbootApplication.class, args);

    // Print a message to indicate the server is listening on port 5000
    System.out.println("Server listening on port 5000");
  }
}
