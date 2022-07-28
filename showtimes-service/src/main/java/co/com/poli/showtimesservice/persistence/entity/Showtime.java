package co.com.poli.showtimesservice.persistence.entity;


import co.com.poli.showtimesservice.model.Movie;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@Entity
@EqualsAndHashCode
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "movies")
    private Long[] movies;

}
