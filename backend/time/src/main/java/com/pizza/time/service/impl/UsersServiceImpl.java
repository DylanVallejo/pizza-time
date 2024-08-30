package com.pizza.time.service.impl;

import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Users;
import com.pizza.time.mapper.Mapper;
import com.pizza.time.repository.UsersRepository;
import com.pizza.time.service.UsersService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {


    private final Mapper mapper;
    private final UsersRepository usersRepository;

    @Override
    @Transactional
    public String testMethod() {
        return "test de prueba";
    }

    @Override
    public UsersDto registerUser(Users user) {

        Users userDB = usersRepository.save(user);
//        UsersDto usersDto = mapper.userToUsersDto(userDB);
        return mapper.userToUsersDto(userDB);
    }


//    @Override
//    @Transactional
//    public UsersDto registerUser(Users user){
//
//        Users userDB = usersRepository.save(user);
////        UsersDto usersDto = mapper.userToUsersDto(userDB);
//        return mapper.userToUsersDto(userDB);
//
//    }


}
