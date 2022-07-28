package co.com.poli.bookingservice.service;

import co.com.poli.bookingservice.persistence.entity.Booking;


import java.util.List;
import java.util.Optional;

public interface BookingService {

    void save(Booking booking);

    void delete(Booking booking);

    List<Booking> findAll();

    Booking findById(Long id);

    List<Booking> findAllByUserId(Long id);

}
