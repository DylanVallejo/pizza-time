package com.pizza.time.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "toppings")
public class Toppings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topics_id;

    @Column(name = "name")
    private String name;

    //    @JoinColumn(name = "pizza")
    @ManyToMany(mappedBy = "toppings") // let the behavior to the other entity
    private List<Pizza> pizzas = new ArrayList<>();

}
