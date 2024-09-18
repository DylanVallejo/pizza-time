package com.pizza.time.controller;


import com.pizza.time.dto.LoginDto;
import com.pizza.time.entity.Token;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<Token> login(@RequestBody LoginDto loginDto) throws GeneralException {
        return loginService.login(loginDto);
    }

}
