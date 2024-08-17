package com.yukode.simpleloginapirest.controller;

import com.yukode.simpleloginapirest.dto.UserDTO;
import com.yukode.simpleloginapirest.dto.UserLoginDTO;
import com.yukode.simpleloginapirest.model.UserModel;
import com.yukode.simpleloginapirest.service.UserService;
import com.yukode.simpleloginapirest.util.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

//    @PostMapping("/login")
//    public ResponseEntity<UserDTO> login(@RequestBody UserLoginDTO userLoginDTO){
//        
//        return userService.authenticate(userLoginDTO.getUsername(), userLoginDTO.getPassword())
//                .map(user -> ResponseEntity.ok(userMapper.toUserDto(user)))
//                .orElseGet((Supplier<? extends ResponseEntity<UserDTO>>) () -> ResponseEntity.status(401).body(null));
//    }
    @PostMapping("/login")
    @Operation(summary = "Login", description = "Endpoint to login user ")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful retrieval a object user",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = UserModel.class))),
        @ApiResponse(responseCode = "401", description = "Invalid Credentials")
    })
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.authenticate(userLoginDTO.getUsername(), userLoginDTO.getPassword())
                .map(user -> ResponseEntity.ok(userMapper.toUserDto(user)))
                .orElseGet((Supplier<? extends ResponseEntity<UserDTO>>) ()-> ResponseEntity.status(401).body(null));
    }

    @PostMapping("/register")
    @Operation(summary = "Register", description = "Endpoint to register a new user ")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful retrieval a object user",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = UserModel.class))),
        @ApiResponse(responseCode = "401", description = "User already exists")
    })
    public ResponseEntity<UserDTO> register(@Parameter( description = "UserModel to be created", required = true) @RequestBody UserLoginDTO userLoginDTO) {

        UserModel user = userService.register(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        return ResponseEntity.ok(userMapper.toUserDto(user));
//       return ResponseEntity.status(200).body(userMapper.toUserDto(user));
    }

}
