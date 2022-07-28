package co.com.poli.userservice.mapper;

import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.service.dto.UserInDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInDtoToUser implements IMapper<UserInDTO, User>{

    @Override
    public User map(UserInDTO in) {
        User user = new User();
        user.setName(in.getName());
        user.setLastName(in.getLastName());

        return user;
    }
}
