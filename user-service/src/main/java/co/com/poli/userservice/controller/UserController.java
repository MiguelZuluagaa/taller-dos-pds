package co.com.poli.userservice.controller;

import co.com.poli.userservice.helpers.Response;
import co.com.poli.userservice.helpers.ResponseBuild;
import co.com.poli.userservice.mapper.UserInDtoToUser;
import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.service.UserService;
import co.com.poli.userservice.service.dto.UserInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuild builder;
    private final UserInDtoToUser mapper;

    @PostMapping
    public Response save(@Valid @RequestBody UserInDTO user, BindingResult result){
        if (result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        userService.save(mapper.map(user));
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id")Long id){

        User user = userService.findById(id);
        if(user!=null){
            Boolean userDeleted = userService.delete(user);
            if(userDeleted){
                return builder.success(user);
            }else{
                return builder.userCanNotDelete();
            }
        }else{
            return builder.userNotExist();
        }



    }

    @GetMapping
    public  Response findAll(){
        return builder.success(userService.findAll());
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
