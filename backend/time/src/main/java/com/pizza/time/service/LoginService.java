package com.pizza.time.service;

import com.pizza.time.dto.LoginDto;
import com.pizza.time.entity.Token;
import com.pizza.time.exceptions.GeneralException;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    ResponseEntity<Token> login(LoginDto loginDto) throws GeneralException;

}
