package com.yukode.simpleloginapirest.repository;

import com.yukode.simpleloginapirest.model.UserModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    
//    Custom method to find a user by username
    Optional<UserModel> findUserByUsername(String username);
}
