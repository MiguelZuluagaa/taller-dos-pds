package co.com.poli.movieservice.service.dto;

import co.com.poli.movieservice.model.Booking;
import co.com.poli.movieservice.model.Showtime;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieInDTO {
    @NotEmpty(message = "El titulo no puede estar vacio")
    private String title;

    @NotEmpty(message = "El director no puede estar vacio")
    private String director;

    @Min(value = 1, message = "El rating debe de ser de 1 a 5")
    @Max(value = 5, message = "El rating debe de ser de 1 a 5")
    private Integer rating;
}
