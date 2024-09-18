package com.pizza.time.service.impl;

import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.repository.OrderRepository;
import com.pizza.time.repository.PizzaRepository;
import com.pizza.time.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<Pizza> createPizza(Pizza pizza) throws GeneralException {
        return null;
    }


}
