package com.pizza.time.service.impl;

import com.pizza.time.dto.GeneralOrderDto;
import com.pizza.time.entity.Orders;
import com.pizza.time.entity.Pizza;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.repository.OrderRepository;
import com.pizza.time.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    @Override
    public Orders generateOrder(Orders generalOrderDto) throws GeneralException{
        try {
//            Orders initalOrder = Orders.builder()
//                    .type(generalOrderDto.getType())
//                    .favorite(generalOrderDto.getFavorite())
//                    .paid(generalOrderDto.getPaid())
////                    .date()
////                    .deliveryFee()
////                    .tax()
////                    .total()
////                    .users()


//            Pizza pizza = Pizza.builder()
//                    .size(generalOrderDto.getSize())
//                    .crust(generalOrderDto.getCrust())
//                    .quantity(generalOrderDto.getQuantity())
//                    .toppings(generalOrderDto.getToppings())
//                    .build();
//
//            initalOrder



//                    completeFields(order);
//            Pizza pizza = Pizza.builder()
//                    .size(order)
//                    .order(initalOrder)
//                    .
            return null;
        }catch (Exception ex){
            throw new GeneralException(ex.getMessage());
        }
//        return null;
    }


    public Orders completeFields(Orders orders){
        BigDecimal total = orders.getTotal();
        double taxRate = 0.15;
        double deliveryFee = 4.50;

        BigDecimal taxRateBigdecimal = BigDecimal.valueOf(taxRate);

        //divide
        BigDecimal subTotal = total.divide(BigDecimal.ONE.add(taxRateBigdecimal),2, RoundingMode.HALF_UP);

        //multiplies
        BigDecimal tax = total.subtract(subTotal);

//        Orders newOrder = Orders.builder()
//                .type(orders.getType())
//                .favorite(false)
//                .paid(false)
////                .date(LocalDate.now())
////                .deliveryFee(BigDecimal.valueOf(deliveryFee))
////                .tax(tax)
////                .total()
////                .users(null)
////                .pizzas()
//                .build();

        //todo                debo extraer el usuario del token para ponerlo en la orden

//        return orderRepository.save(newOrder);
        return null;
    }

}
