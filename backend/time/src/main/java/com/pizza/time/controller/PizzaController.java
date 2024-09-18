package com.pizza.time.controller;


import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) throws GeneralException {
        return pizzaService.createPizza(pizza);
    }


}
