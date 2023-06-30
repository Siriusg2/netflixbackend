package com.consulti.templatespringboot.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

@Service
public class GetContentService {

  HttpClient httpClient = HttpClient
    .newBuilder()
    .connectTimeout(Duration.ofSeconds(10))
    .build();

  public List<String> fetchDataFromEndpoints(List<String> endpoints) {
    List<String> responses = new ArrayList<>();

    List<CompletableFuture<String>> futures = new ArrayList<>();
    for (String endpoint : endpoints) {
      if (endpoint != null) {
        HttpRequest request = HttpRequest
          .newBuilder()
          .uri(URI.create(endpoint))
          .build();

        CompletableFuture<String> future = httpClient
          .sendAsync(request, HttpResponse.BodyHandlers.ofString())
          .thenApply(HttpResponse::body);

        futures.add(future);
      }
    }

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    for (CompletableFuture<String> future : futures) {
      try {
        String response = future.get();
        responses.add(response);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    return responses;
  }
}
