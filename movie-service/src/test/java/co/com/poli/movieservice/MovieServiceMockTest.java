package co.com.poli.movieservice;

import co.com.poli.movieservice.clientFeign.ShowtimesClient;
import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import co.com.poli.movieservice.service.MovieService;
import co.com.poli.movieservice.service.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowtimesClient ShowtimesClient;

    @BeforeEach
    public void begin(){

        MockitoAnnotations.openMocks(this);
        movieService = new MovieServiceImpl(movieRepository,ShowtimesClient);

        Movie movie = new Movie();
        movie.setTitle("Hola");
        movie.setDirector("Holaaa");
        movie.setRating(5);

        movieRepository.save(movie);

        MovieService mock = org.mockito.Mockito.mock(MovieService.class);
        Mockito.when(mock.findById(1L))
                .thenReturn(movie);
    }

    @Test
    public void when_findById_return_movie(){
        Movie movie = movieService.findById(1L);
        Assertions.assertThat(movie.getTitle()).isEqualTo("Hola");
    }
}
