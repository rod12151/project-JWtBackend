package com.rodmeljwt.backend.controllers;

import com.rodmeljwt.backend.config.UserAuthProvider;
import com.rodmeljwt.backend.dto.CredentialsDto;
import com.rodmeljwt.backend.dto.SingUpDto;
import com.rodmeljwt.backend.dto.UserDto;
import com.rodmeljwt.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.ok(user);
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SingUpDto singUpDto){
        UserDto user = userService.register(singUpDto);
        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.created(URI.create("/users/"+user.getId()))
                .body(user);
    }
}
