package co.com.poli.movieservice.persistence.entity;

import co.com.poli.movieservice.model.Booking;
import co.com.poli.movieservice.model.Showtime;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @NotEmpty(message = "El titulo no puede estar vacio")
    private String title;

    @NotEmpty(message = "El director no puede estar vacio")
    private String director;

    @Min(value = 1, message = "El rating debe de ser de 1 a 5")
    @Max(value = 5, message = "El rating debe de ser de 1 a 5")
    private Integer rating;

    @Transient
    private Booking booking;
    @Transient
    private Showtime showtime;
}
