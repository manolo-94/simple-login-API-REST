package com.yukode.simpleloginapirest.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    public String encodePassword(String password){
        
        return bCryptPasswordEncoder.encode(password);
    }
    
    public Boolean matches(String rawPassword, String encodePassword){
        
        return bCryptPasswordEncoder.matches(rawPassword, encodePassword);
        
    }
    
}
