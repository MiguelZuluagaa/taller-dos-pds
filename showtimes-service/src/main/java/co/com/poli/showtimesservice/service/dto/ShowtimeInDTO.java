package co.com.poli.showtimesservice.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowtimeInDTO {

    //@NotEmpty(message = "La fecha no puede estar vacia")
    @NotNull(message = "La fecha no puede estar vacia")
    private LocalDateTime date;

    private Long[] movies;

}
