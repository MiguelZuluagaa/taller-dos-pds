
package co.com.poli.showtimesservice.controller;

import co.com.poli.showtimesservice.helpers.Response;
import co.com.poli.showtimesservice.helpers.ResponseBuild;
import co.com.poli.showtimesservice.mapper.ShowtimeInDtoToShowtime;
import co.com.poli.showtimesservice.persistence.entity.Showtime;
import co.com.poli.showtimesservice.service.ShowtimeService;
import co.com.poli.showtimesservice.service.dto.ShowtimeInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;
    private final ShowtimeInDtoToShowtime mapper;

    @PostMapping
    public Response save(@Valid @RequestBody ShowtimeInDTO showtime, BindingResult result){
        if (result.hasErrors()){
            return  builder.failed((this.formatMessage(result)));
        }
        showtimeService.save(mapper.map(showtime));
        return builder.success(showtime);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(showtimeService.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id){
        return builder.success(showtimeService.findById(id));
    }

    @PutMapping("/{id}")
    public Response updateBydId(@PathVariable Long id, @RequestBody @Valid Showtime showtime){
        Showtime showtimeData = showtimeService.findById(id);
        showtimeData.setDate(showtime.getDate());
        showtimeData.setMovies(showtime.getMovies());
        showtimeService.save(showtimeData);
        return builder.success(showtimeData);
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }
}
