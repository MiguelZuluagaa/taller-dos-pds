package co.com.poli.showtimesservice.clientFeign;

import co.com.poli.showtimesservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service" , fallback = MovieClientImplHystrixFallBack.class)
public interface MovieClient {

    @GetMapping("/store/api/v1/movies/{id}")
    Response findByID(@PathVariable("id") Long id);

}
