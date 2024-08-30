package com.pizza.time.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer userId;

//    @Column(name = "name")
    public String name;

    public String lastName;

    public String email;

    public String adress;

    public String city;

    public String state;

    public String password;

}
