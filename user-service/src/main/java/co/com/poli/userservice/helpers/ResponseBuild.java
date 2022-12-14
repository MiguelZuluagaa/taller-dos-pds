package co.com.poli.userservice.helpers;

import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Component
public class ResponseBuild {

    public Response success() {
        return Response.builder()
                .data(OK)
                .code(OK.value()).build();
    }

    public Response success(Object data) {
        return Response.builder()
                .data(data)
                .code(OK.value()).build();
    }

    public Response userCanNotDelete() {
        return Response.builder()
                .data("Este usuario no puede ser removida")
                .code(OK.value()).build();
    }

    public Response userNotExist() {
        return Response.builder()
                .data("Este usuario no existe")
                .code(OK.value()).build();
    }

    public Response failed(Object data) {
        return Response.builder()
                .data(data)
                .code(INTERNAL_SERVER_ERROR.value()).build();
    }

}
