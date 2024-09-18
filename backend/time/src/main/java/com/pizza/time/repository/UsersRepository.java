package com.pizza.time.repository;

import com.pizza.time.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(@Param("email") String email);

}
