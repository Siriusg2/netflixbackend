package com.consulti.templatespringboot.utils.DTO;

import java.util.List;
import lombok.Data;

@Data
public class FilmDTo {

  private Boolean adult;
  private String backdropPath;
  private List<Integer> genreIds;
  private int id;
  private String originalLanguage;
  private String originalTitle;
  private String overview;
  private double popularity;
  private String posterPath;
  private String releaseDate;
  private String title;
  private boolean video;
  private double voteAverage;
  private int voteCount;
}
