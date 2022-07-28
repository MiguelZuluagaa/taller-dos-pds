package co.com.poli.bookingservice.persistence.repository;

import co.com.poli.bookingservice.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByUserId(Long userId);

}
