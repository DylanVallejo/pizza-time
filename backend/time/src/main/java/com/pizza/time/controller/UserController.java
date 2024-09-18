package com.pizza.time.controller;


import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Users;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<UsersDto> createUser(@RequestBody  Users newUser) throws GeneralException {

        return new ResponseEntity<>(usersService.registerUser(newUser), HttpStatus.CREATED);

    }

    @GetMapping("/asegurado")
    public String jwtTest(){
        return "hello world";
    }



}
