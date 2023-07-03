package com.consulti.templatespringboot.utils.DTO;

import lombok.Data;

@Data
public class Response {

  public Response(int page, FilmDTo[] results) {
    this.page = page;
    this.results = results;
  }

  private int page;
  private FilmDTo[] results;
}
