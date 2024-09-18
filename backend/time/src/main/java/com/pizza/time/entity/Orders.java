package com.pizza.time.entity;


import com.pizza.time.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "favorite")
    private Boolean favorite;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "deliveryFee")
    private BigDecimal deliveryFee;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

//    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "order")
    private List<Pizza> pizzas = new ArrayList<>();

}
