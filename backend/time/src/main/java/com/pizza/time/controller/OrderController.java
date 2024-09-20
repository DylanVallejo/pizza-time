package com.pizza.time.controller;

import com.pizza.time.entity.Orders;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> generateNewOrder(@RequestBody Orders order) throws GeneralException {

        return new ResponseEntity<>(orderService.generateOrder(order), HttpStatus.CREATED);

    }

}
