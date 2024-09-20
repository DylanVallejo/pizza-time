package com.pizza.time.dto;


import com.pizza.time.entity.Orders;
import com.pizza.time.entity.Pizza;
import com.pizza.time.entity.Toppings;
import com.pizza.time.entity.Users;
import com.pizza.time.enums.Crust;
import com.pizza.time.enums.Size;
import com.pizza.time.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class GeneralOrderDto {


    private Type type;

    private Boolean favorite;

    private Boolean paid;

    private LocalDate date;

    private BigDecimal deliveryFee;

    private BigDecimal tax;

    private BigDecimal total;

    // todo cuidao pizza

    private Size size;

    private Crust crust;

    private Integer quantity;

    private BigDecimal price;

    private List<Toppings> toppings;

}
