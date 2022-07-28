package co.com.poli.bookingservice.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingInDTO {

    @NotEmpty(message = "El userId no puede estar vacio")
    @Column(name = "user_id")
    private Long userId;

    @NotEmpty(message = "El showtimesId no puede estar vacio")
    @Column(name = "showtimes_id")
    private Long showtimesId;
}
