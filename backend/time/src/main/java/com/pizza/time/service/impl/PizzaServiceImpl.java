package com.pizza.time.service.impl;

import com.pizza.time.dto.PizzaDto;
import com.pizza.time.entity.Orders;
import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.mapper.Mapper;
import com.pizza.time.repository.OrderRepository;
import com.pizza.time.repository.PizzaRepository;
import com.pizza.time.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;
    private final Mapper mapper;

    @Override
    public Pizza createPizza(PizzaDto pizzaDto) throws GeneralException {
        try {

            Pizza newPizza =  mapper.pizzaDtoToEntity(pizzaDto);

//            todo creation of a new order for pizzas
            Orders newOrder = Orders.builder()
                    .paid(false)
                    .date(LocalDate.now())
                    .favorite(false)
//                    extract token to assign a user
                    .pizzas(List.of(newPizza))
                    .build();
            Orders orderDB= orderRepository.save(newOrder);
            newPizza.setOrder(orderDB);
            return pizzaRepository.save(newPizza);

        }catch (Exception ex){
            throw new GeneralException(ex.getMessage());
        }
    }


}
