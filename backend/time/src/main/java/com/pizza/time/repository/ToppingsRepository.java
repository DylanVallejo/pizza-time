package com.pizza.time.repository;

import com.pizza.time.entity.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Integer> {

}
