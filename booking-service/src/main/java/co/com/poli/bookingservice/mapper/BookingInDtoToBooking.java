package co.com.poli.bookingservice.mapper;

import co.com.poli.bookingservice.persistence.entity.Booking;
import co.com.poli.bookingservice.service.dto.BookingInDTO;

public class BookingInDtoToBooking implements IMapper<BookingInDTO, Booking> {
    @Override
    public Booking map(BookingInDTO in) {
        Booking booking = new Booking();
        booking.setUserId(in.getUserId());
        booking.setShowtimesId(in.getShowtimesId());
        return booking;
    }
}
