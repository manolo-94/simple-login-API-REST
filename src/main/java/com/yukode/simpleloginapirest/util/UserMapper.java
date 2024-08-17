package com.yukode.simpleloginapirest.util;

import com.yukode.simpleloginapirest.dto.UserDTO;
import com.yukode.simpleloginapirest.model.UserModel;
import org.springframework.stereotype.Component;

// La anotacion @Component es una anotacion esteriotipada generica usada para marcar una clase java como un componente administrado por Spring.
// La anotacion @Component le esta diciendo a Spring que trate la clase como un Spring Bean.

@Component
public class UserMapper {
    
    public UserDTO toUserDto(UserModel userModel){
        UserDTO dto = new UserDTO();
        
        dto.setId_username(userModel.getId_username());
        dto.setUsername(userModel.getUsername());
        
        return dto;
    }
    
    public UserModel toUserModel(UserDTO userDTO){
        
        UserModel user = new UserModel();
        
        user.setId_username(userDTO.getId_username());
        user.setUsername(userDTO.getUsername());
        
        return user;
    }
}
