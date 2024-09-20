package com.pizza.time.dto;


import com.pizza.time.entity.Toppings;
import com.pizza.time.enums.Crust;
import com.pizza.time.enums.Size;
import com.pizza.time.enums.Type;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class PizzaDto {

    private Type type;

    private Size size;

    private Crust crust;

    private Integer quantity;

    private BigDecimal price;

    private List<Toppings> toppings;

}
