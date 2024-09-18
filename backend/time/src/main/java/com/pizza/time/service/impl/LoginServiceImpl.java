package com.pizza.time.service.impl;

import com.pizza.time.dto.LoginDto;
import com.pizza.time.entity.Token;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.security.CustomerDetailsService;
import com.pizza.time.security.jwt.JwtUtil;
import com.pizza.time.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerDetailsService customerDetailsService;

    @Override
    public ResponseEntity<Token> login(LoginDto loginDto) throws GeneralException {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

            if(authentication.isAuthenticated()){
                Token token = new Token();
                token.setToken(jwtUtil.generateToken(customerDetailsService.getUserDetails().getEmail(),customerDetailsService.getUserDetails().getUserId(),customerDetailsService.getUserDetails().getName()));
                return new ResponseEntity<>(token, HttpStatus.OK);
            }

        } catch (Exception ex) {
            throw new GeneralException(ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
