package com.consulti.templatespringboot.services.impl;

import com.consulti.templatespringboot.utils.DTO.FilmDTo;
import com.consulti.templatespringboot.utils.DTO.SeriesDTO;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetContentFromExtApiService {

  @Value("${authorization.token_NETFLIX}")
  private String authorizationToken;

  HttpClient httpClient = HttpClient
    .newBuilder()
    .connectTimeout(Duration.ofSeconds(10))
    .build();

  public List<Object> fetchDataFromEndpoints(List<String> endpoints) {
    List<Object> contentList = new ArrayList<>();

    List<CompletableFuture<JSONArray>> futures = new ArrayList<>();
    for (String endpoint : endpoints) {
      if (endpoint != null) {
        HttpRequest request = HttpRequest
          .newBuilder()
          .header("accept", "application/json")
          .header("Authorization", authorizationToken)
          .uri(URI.create(endpoint))
          .build();

        CompletableFuture<JSONArray> future = httpClient
          .sendAsync(request, HttpResponse.BodyHandlers.ofString())
          .thenApply(response -> {
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getJSONArray("results");
          });

        futures.add(future);
      }
    }

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    for (CompletableFuture<JSONArray> future : futures) {
      try {
        JSONArray responseArray = future.get();

        for (int i = 0; i < responseArray.length(); i++) {
          JSONObject iteration = new JSONObject(
            responseArray.get(i).toString()
          );
          contentList.add(mapToContentDTO(iteration));
        }
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    return contentList;
  }

  private Object mapToContentDTO(JSONObject jsonObject) {
    if (jsonObject.length() > 13) {
      FilmDTo filmDTO = new FilmDTo();
      filmDTO.setAdult(jsonObject.optBoolean("adult"));
      filmDTO.setBackdropPath(jsonObject.optString("backdrop_path"));
      filmDTO.setGenreIds(getIntegerList(jsonObject.optJSONArray("genre_ids")));
      filmDTO.setId(jsonObject.optInt("id"));
      filmDTO.setOriginalLanguage(jsonObject.optString("original_language"));
      filmDTO.setOriginalTitle(jsonObject.optString("original_title"));
      filmDTO.setOverview(jsonObject.optString("overview"));
      filmDTO.setPopularity(jsonObject.optDouble("popularity"));
      filmDTO.setPosterPath(jsonObject.optString("poster_path"));
      filmDTO.setReleaseDate(jsonObject.optString("release_date"));
      filmDTO.setTitle(jsonObject.optString("title"));
      filmDTO.setVideo(jsonObject.optBoolean("video"));
      filmDTO.setVoteAverage(jsonObject.optDouble("vote_average"));
      filmDTO.setVoteCount(jsonObject.optInt("vote_count"));

      return filmDTO;
    } else {
      SeriesDTO seriesDTO = new SeriesDTO();

      seriesDTO.setBackdropPath(jsonObject.optString("backdrop_path"));
      seriesDTO.setFirstAirDate(jsonObject.optString("first_air_date"));
      seriesDTO.setGenreIds(
        getIntegerList(jsonObject.optJSONArray("genre_ids"))
      );
      seriesDTO.setId(jsonObject.optInt("id"));
      seriesDTO.setName(jsonObject.optString("name"));
      seriesDTO.setOriginCountry(
        getStringList(jsonObject.optJSONArray("origin_country"))
      );
      seriesDTO.setOriginalLanguage(jsonObject.optString("original_language"));
      seriesDTO.setOriginalName(jsonObject.optString("original_name"));
      seriesDTO.setOverview(jsonObject.optString("overview"));
      seriesDTO.setPopularity(jsonObject.optDouble("popularity"));
      seriesDTO.setPosterPath(jsonObject.optString("poster_path"));
      seriesDTO.setVoteAverage(jsonObject.optDouble("vote_average"));
      seriesDTO.setVoteCount(jsonObject.optInt("vote_count"));
      return seriesDTO;
    }
  }

  private List<Integer> getIntegerList(JSONArray jsonArray) {
    List<Integer> list = new ArrayList<>();
    if (jsonArray != null) {
      for (int i = 0; i < jsonArray.length(); i++) {
        list.add(jsonArray.optInt(i));
      }
    }
    return list;
  }

  private List<String> getStringList(JSONArray jsonArray) {
    List<String> list = new ArrayList<>();
    if (jsonArray != null) {
      for (int i = 0; i < jsonArray.length(); i++) {
        list.add(jsonArray.optString(i));
      }
    }
    return list;
  }
}
