package com.pizza.time.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany(mappedBy = "toppings", fetch=FetchType.LAZY) // let the behavior to the other entity
    @JsonIgnore
    private List<Pizza> pizzas = new ArrayList<>();

}
