package com.pizza.time.entity;


import com.pizza.time.enums.Crust;
import com.pizza.time.enums.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    public Integer pizzaId;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    public Size size;

    @Column(name = "crust")
    @Enumerated(EnumType.STRING)
    public Crust crust;

    @Column(name = "quantity")
    public Integer quantity;

    @Column(name = "price")
    public BigDecimal price;

    @Column(name = "orders_order_id")
    public Integer orders_order_id;

}
