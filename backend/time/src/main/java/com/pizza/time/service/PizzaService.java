package com.pizza.time.service;

import com.pizza.time.dto.PizzaDto;
import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;

public interface PizzaService {

    Pizza createPizza(PizzaDto pizzaDto) throws GeneralException;

}
