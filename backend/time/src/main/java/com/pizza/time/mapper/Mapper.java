package com.pizza.time.mapper;


import com.pizza.time.dto.PizzaDto;
import com.pizza.time.dto.ToppingsDto;
import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Pizza;
import com.pizza.time.entity.Toppings;
import com.pizza.time.entity.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {

    public UsersDto userToUsersDto(Users user){
        UsersDto usersDto = new UsersDto();
        BeanUtils.copyProperties(user, usersDto);
        return usersDto;
    }

    public ToppingsDto toppingsToToppingsDto(Toppings toppings){
        ToppingsDto toppingsDto = new ToppingsDto();
        BeanUtils.copyProperties(toppings, toppingsDto);
        return toppingsDto;
    }

    public Pizza pizzaDtoToEntity(PizzaDto pizzaDto){
        Pizza newPizza = new Pizza();
        BeanUtils.copyProperties(pizzaDto,newPizza);
        return newPizza;
    }

}
