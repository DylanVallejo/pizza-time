package com.pizza.time.mapper;


import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UsersDto userToUsersDto(Users user){
        UsersDto usersDto = new UsersDto();
        BeanUtils.copyProperties(user, usersDto);
        return usersDto;
    }

}
