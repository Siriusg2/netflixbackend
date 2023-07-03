package com.consulti.templatespringboot.utils.DTO;

import java.util.List;
import lombok.Data;

@Data
public class FilmDTo {

  private int id;
  private String name;
  private String title;
  private String originalTitle;
  private String releaseDate;
  private boolean video;
  private String backdropPath;
  private String firstAirDate;
  private List<Integer> genreIds;
  private List<String> originCountry;
  private String originalLanguage;
  private String originalName;
  private String overview;
  private double popularity;
  private String posterPath;
  private double voteAverage;
  private boolean adult;
  private int voteCount;
}
