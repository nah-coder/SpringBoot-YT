package com.example.demo.controller;

import com.example.demo.DTO.Request.ApiReponse;
import com.example.demo.DTO.Reponse.AuthenticationReponse;
import com.example.demo.DTO.Request.AuthenticationRequest;
import com.example.demo.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiReponse<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        var result = authenticationService.Authenticate(authenticationRequest);
        return ApiReponse.<AuthenticationReponse>builder()
                .result(result)
                .build();
    }
}
