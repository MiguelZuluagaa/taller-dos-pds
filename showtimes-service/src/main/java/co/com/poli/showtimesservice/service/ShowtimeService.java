package co.com.poli.showtimesservice.service;

import co.com.poli.showtimesservice.persistence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {

    void save(Showtime showtime);

    void delete(Showtime showtime);

    List<Showtime> findAll();

    Showtime findById(Long id);
}
