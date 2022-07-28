package co.com.poli.movieservice.mapper;

import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.service.dto.MovieInDTO;

public class MovieInDtoToMovie implements IMapper<MovieInDTO, Movie> {

    @Override
    public Movie map(MovieInDTO in) {
        Movie movie = new Movie();
        movie.setTitle(in.getTitle());
        movie.setDirector(in.getDirector());
        movie.setRating(in.getRating());
        return movie;
    }
}
