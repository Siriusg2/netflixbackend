package com.consulti.templatespringboot.utils.DTO;

import java.util.List;
import lombok.Data;

@Data
public class SeriesDTO {

  private String backdropPath;
  private String firstAirDate;
  private List<Integer> genreIds;
  private int id;
  private String name;
  private List<String> originCountry;
  private String originalLanguage;
  private String originalName;
  private String overview;
  private double popularity;
  private String posterPath;
  private double voteAverage;
  private int voteCount;
}
