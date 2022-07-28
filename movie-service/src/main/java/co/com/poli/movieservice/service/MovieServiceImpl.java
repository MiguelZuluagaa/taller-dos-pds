package co.com.poli.movieservice.service;

import co.com.poli.movieservice.clientFeign.BookingClient;
import co.com.poli.movieservice.clientFeign.ShowtimesClient;
import co.com.poli.movieservice.helpers.ResponseBuild;
import co.com.poli.movieservice.model.Booking;
import co.com.poli.movieservice.model.Showtime;
import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.persistence.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final ShowtimesClient showtimesClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Movie movie) {
        Long movieIdValidate = movie.getId();

        ModelMapper modelMapper = new ModelMapper();

        Object showtimesResponse = showtimesClient.findAll().getData();

        if(showtimesResponse.equals(true)){
            return false;
        }else {
            ArrayList<Object> showtimesMaps = (ArrayList<Object>) showtimesResponse;
            List<Showtime> showtimes = showtimesMaps.stream().map(showtime -> modelMapper.map(showtime, Showtime.class)).collect(Collectors.toList());

            Boolean deleteMovie = false;

            for (Showtime showtime : showtimes) {
                Long[] moviesData = showtime.getMovies();
                for (Long movieId : moviesData) {
                    if (movieId == movieIdValidate) {
                        deleteMovie = true;
                    }
                }
            }


            if (!deleteMovie) {
                movieRepository.delete(movie);
                return true;
            } else {
                return false;
            }
        }


    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
