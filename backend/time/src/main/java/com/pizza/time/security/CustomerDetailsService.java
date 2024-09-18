package com.pizza.time.security;


import com.pizza.time.entity.Users;
import com.pizza.time.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    private Users userDetail;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        log.info("Finding user {}", userEmail);
        userDetail = usersRepository.findByEmail(userEmail);
        if(!Objects.isNull(userDetail)){
            return new User(userDetail.getEmail(),userDetail.getPassword(), new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found!");
        }
    }

    public Users getUserDetails(){ return userDetail; }
}
