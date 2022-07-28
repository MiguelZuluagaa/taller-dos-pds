package co.com.poli.movieservice.clientFeign;

import co.com.poli.movieservice.helpers.Response;
import co.com.poli.movieservice.helpers.ResponseBuild;
import co.com.poli.movieservice.persistence.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@RequiredArgsConstructor
public class ShowtimesClientImplHystrixFallBack implements ShowtimesClient{

    private final ResponseBuild build;

    @Override
    public Response findAll(){ return build.success(true); }

}
