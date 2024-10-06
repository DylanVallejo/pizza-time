package com.pizza.time.entity;


import com.pizza.time.enums.Crust;
import com.pizza.time.enums.Size;
import com.pizza.time.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private Integer pizzaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "crust")
    @Enumerated(EnumType.STRING)
    private Crust crust;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;


//    @Column(name = "orders_order_id")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JoinTable(
            name = "pizza_toppings",  //name of the intermediate table
            joinColumns = @JoinColumn(name = "pizza_id"), //name of the foreign key in pizza
            inverseJoinColumns = @JoinColumn(name = "topics_id")// name of the foreign key in toppings
    )
    private List<Toppings> toppings = new ArrayList<>();

    //    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Orders order;

}
