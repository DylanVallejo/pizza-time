package com.pizza.time.service;


import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Users;
import com.pizza.time.exceptions.GeneralException;


public interface UsersService {

    UsersDto registerUser(Users user) throws GeneralException;

}
