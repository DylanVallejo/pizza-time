package com.pizza.time.controller;


import com.pizza.time.dto.PizzaDto;
import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Pizza> createPizza(@RequestBody PizzaDto pizzaDto) throws GeneralException {
        return new ResponseEntity<>(pizzaService.createPizza(pizzaDto), HttpStatus.CREATED);
    }


}
