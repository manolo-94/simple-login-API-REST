package com.yukode.simpleloginapirest.service;

import com.yukode.simpleloginapirest.exception.InvalidCredentialsException;
import com.yukode.simpleloginapirest.exception.UserAlreadyExistsException;
import com.yukode.simpleloginapirest.model.UserModel;
import com.yukode.simpleloginapirest.repository.UserRepository;
import com.yukode.simpleloginapirest.util.PasswordEncoder;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Optional<UserModel> authenticate(String username, String password){
        
        Optional<UserModel> user = userRepository.findUserByUsername(username);
        
        if(!user.isPresent() || !passwordEncoder.matches(password, user.get().getPassword())){
            throw new InvalidCredentialsException("Credenciales incorrectas verifique la informacion.");
        }
        
        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())){
            return user;
        }
        
        return Optional.empty();
        
    }
    
    public UserModel register(String username, String password){
        
        if(userRepository.findUserByUsername(username).isPresent()){
            
            throw new UserAlreadyExistsException("El usuario " + username + " ya existe!!");
        }
        
        UserModel newUser = new UserModel();
        
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encodePassword(password));
        
        return userRepository.save(newUser);
        
    }
    
}
