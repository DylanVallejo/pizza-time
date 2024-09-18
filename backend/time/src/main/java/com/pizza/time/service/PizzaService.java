package com.pizza.time.service;

import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;
import org.springframework.http.ResponseEntity;

public interface PizzaService {

    ResponseEntity<Pizza> createPizza(Pizza pizza) throws GeneralException;

}
