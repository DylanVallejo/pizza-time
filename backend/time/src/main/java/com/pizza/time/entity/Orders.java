package com.pizza.time.entity;


import com.pizza.time.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer order_id;

    @Enumerated(EnumType.STRING)
    public Type type;

    public Boolean favorite;

    public Boolean paid;

    public LocalDate date;

    public BigDecimal deliveryFee;

    public BigDecimal tax;

    public BigDecimal total;

    public Integer users_user_id;

}
