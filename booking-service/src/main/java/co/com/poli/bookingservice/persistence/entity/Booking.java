package co.com.poli.bookingservice.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    //@NotEmpty(message = "El userId no puede estar vacio")
    //@NotBlank(message = "El userId no puede estar vacio")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    //@NotEmpty(message = "El showtimesId no puede estar vacio")
    //@NotBlank(message = "El showtimesId no puede estar vacio")
    @Column(name = "showtimes_id", nullable = false)
    private Long showtimesId;

}
