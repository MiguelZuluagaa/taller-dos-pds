package co.com.poli.movieservice.clientFeign;

import co.com.poli.movieservice.helpers.Response;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "booking-service", fallback = BookingClientImplHystrixFallBack.class)
public interface BookingClient {

    @GetMapping("/movie/api/v1/bookings/")
    Response findAll();

}
