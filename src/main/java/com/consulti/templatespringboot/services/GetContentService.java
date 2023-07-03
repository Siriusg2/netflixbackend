package com.consulti.templatespringboot.services;

import com.consulti.templatespringboot.utils.DTO.FilmDTo;
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
import org.springframework.stereotype.Service;

@Service
public class GetContentService {

  HttpClient httpClient = HttpClient
    .newBuilder()
    .connectTimeout(Duration.ofSeconds(10))
    .build();

  public List<FilmDTo> fetchDataFromEndpoints(List<String> endpoints) {
    List<FilmDTo> contentList = new ArrayList<>();

    List<CompletableFuture<JSONArray>> futures = new ArrayList<>();
    for (String endpoint : endpoints) {
      if (endpoint != null) {
        HttpRequest request = HttpRequest
          .newBuilder()
          .header("accept", "application/json")
          .header(
            "Authorization",
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0OWJkMzY5ZWI2MjQzZTRjMjRiZDlmYmMzNTVhOTk0MCIsInN1YiI6IjY0OWVjYTYwYzlkYmY5MDEwN2UxY2Y1MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ._CrwC8_UAwCQLeMMLpIEPGBxu0TpM5wTmMAzokg6Ty8"
          )
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
          JSONObject response = responseArray.getJSONObject(i);
          FilmDTo contentDTO = mapToFilmDTo(response);
          contentList.add(contentDTO);
        }
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    return contentList;
  }

  private FilmDTo mapToFilmDTo(JSONObject jsonObject) {
    FilmDTo contentDTO = new FilmDTo();
    contentDTO.setId(jsonObject.optInt("id"));
    contentDTO.setName(jsonObject.optString("name"));
    contentDTO.setTitle(jsonObject.optString("title"));
    contentDTO.setOriginalTitle(jsonObject.optString("original_title"));
    contentDTO.setReleaseDate(jsonObject.optString("release_date"));
    contentDTO.setVideo(jsonObject.optBoolean("video"));
    contentDTO.setBackdropPath(jsonObject.optString("backdrop_path"));
    contentDTO.setFirstAirDate(jsonObject.optString("first_air_date"));
    contentDTO.setGenreIds(
      getIntegerList(jsonObject.optJSONArray("genre_ids"))
    );
    contentDTO.setOriginCountry(
      getStringList(jsonObject.optJSONArray("origin_country"))
    );
    contentDTO.setOriginalLanguage(jsonObject.optString("original_language"));
    contentDTO.setOriginalName(jsonObject.optString("original_name"));
    contentDTO.setOverview(jsonObject.optString("overview"));
    contentDTO.setPopularity(jsonObject.optDouble("popularity"));
    contentDTO.setPosterPath(jsonObject.optString("poster_path"));
    contentDTO.setVoteAverage(jsonObject.optDouble("vote_average"));
    contentDTO.setAdult(jsonObject.optBoolean("adult"));
    contentDTO.setVoteCount(jsonObject.optInt("vote_count"));

    return contentDTO;
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
