package com.dyplom.travel.api;

import com.dyplom.travel.services.UserService;
import com.dyplom.travel.services.models.CreateUserRequest;
import com.dyplom.travel.services.models.ResponseUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/public/users")
@RestController
public class UserController {

    private final UserService service;

    @PostMapping(value = "/login")
    public ResponseEntity<ResponseUserDto> login(@RequestParam String username,
                                                 @RequestParam String password) {
        return ResponseEntity.ok(service.login(username, password));
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUserDto> register(@RequestBody @Valid CreateUserRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping(value = "/check-login")
    public ResponseEntity<ResponseUserDto> checkLogin(Authentication authentication) {
        return ResponseEntity.ok(service.checkLogin(authentication));
    }
}
