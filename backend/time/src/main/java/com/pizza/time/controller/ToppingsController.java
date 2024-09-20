package com.pizza.time.controller;


import com.pizza.time.dto.ToppingsDto;
import com.pizza.time.entity.Toppings;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.service.ToppingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/toppings")
public class ToppingsController {

    private final ToppingsService toppingsService;

    @PostMapping
    public ResponseEntity<ToppingsDto> createTopic(@RequestBody Toppings toppings) throws GeneralException {
        return new ResponseEntity<>(toppingsService.createTopic(toppings), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Toppings>> getAllToppings() throws GeneralException {
        return new ResponseEntity<>(toppingsService.getToppings(), HttpStatus.OK);
    }

}
