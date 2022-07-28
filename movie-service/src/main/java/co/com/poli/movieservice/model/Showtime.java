package co.com.poli.movieservice.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Showtime {


    private Long id;
    private LocalDateTime date;
    private Long[] movies;

}
