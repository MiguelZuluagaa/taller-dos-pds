package co.com.poli.movieservice.service;

import co.com.poli.movieservice.persistence.entity.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);

    Boolean delete(Movie movie);

    List<Movie> findAll();

    Movie findById(Long id);
}
