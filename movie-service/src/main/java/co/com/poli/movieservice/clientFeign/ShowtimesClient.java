package co.com.poli.movieservice.clientFeign;

import co.com.poli.movieservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "showtime-service", fallback = ShowtimesClientImplHystrixFallBack.class)
public interface ShowtimesClient {

    @GetMapping("/movie/api/v1/showtimes/")
    Response findAll();
}
