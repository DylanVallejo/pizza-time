package com.pizza.time.service;


import com.pizza.time.dto.ToppingsDto;
import com.pizza.time.entity.Toppings;
import com.pizza.time.exceptions.GeneralException;

public interface ToppingsService {

    ToppingsDto createTopic(Toppings toppings) throws GeneralException;

}
