package co.com.poli.showtimesservice.mapper;

import co.com.poli.showtimesservice.persistence.entity.Showtime;
import co.com.poli.showtimesservice.service.dto.ShowtimeInDTO;
import org.springframework.stereotype.Component;

@Component
public class ShowtimeInDtoToShowtime implements IMapper<ShowtimeInDTO, Showtime> {
    @Override
    public Showtime map(ShowtimeInDTO in) {
        Showtime showtime = new Showtime();
        showtime.setDate(in.getDate());
        showtime.setMovies(in.getMovies());
        return showtime;
    }
}
