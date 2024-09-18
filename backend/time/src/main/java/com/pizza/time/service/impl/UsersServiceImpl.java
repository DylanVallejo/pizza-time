package com.pizza.time.service.impl;

import com.pizza.time.dto.UsersDto;
import com.pizza.time.entity.Users;
import com.pizza.time.exceptions.GeneralException;
import com.pizza.time.mapper.Mapper;
import com.pizza.time.repository.UsersRepository;
import com.pizza.time.service.UsersService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final Mapper mapper;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UsersDto registerUser(Users user) throws GeneralException {
        try {
            Users validateUser = usersRepository.findByEmail(user.getEmail());
            if(Objects.isNull(validateUser)){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                Users newUser = usersRepository.save(user);
                return mapper.userToUsersDto(newUser);
            } else {
              throw new GeneralException("User whit email: " + user.getEmail() + " already exist!");
            }
        }catch (Exception e){
            throw new GeneralException(e.getMessage());
        }
    }


}
