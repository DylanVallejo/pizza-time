package com.pizza.time.repository;

import com.pizza.time.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
