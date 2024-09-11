package com.pizza.time.service;


import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Users;
import org.springframework.stereotype.Service;


public interface UsersService {


    UsersDto registerUser(Users user);


}
