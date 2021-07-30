package com.petservice.service.impl;

import com.petservice.dto.LoginDto;
import com.petservice.dto.LoginResponseDto;
import com.petservice.entity.UserDetails;
import com.petservice.exception.AuthenticationException;
import com.petservice.exception.NoSuchUserException;
import com.petservice.repository.UserDetailsRepository;
import com.petservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private final UserDetailsRepository repository;
    @Autowired
    private final BCryptPasswordEncoder bcryptEncoder;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String userId) {
        UserDetails user = repository.findByUserId(userId);
        if(user == null){
            log.info("Login failed");
            throw new NoSuchUserException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), getAuthority());
    }
    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }


    public UserDetails getUserByUserId(String userId){
        if (repository.existsUserDetailsByUserId(userId))
            return repository.findByUserId(userId);
        else {
            log.info("User doesn't exist");
            throw new NoSuchUserException("User cannot be found");
        }
    }
    public LoginResponseDto login(LoginDto dto) {
        UserDetails customer = repository.findByUserId(dto.getUserId());
        if (customer == null) {
            throw new NoSuchUserException("Customer can not be found");
        }
        if (bcryptEncoder.matches(dto.getPassword(), customer.getPassword()))
            return LoginResponseDto.builder()
                    .customerName(customer.getUserName())
                    .message("login successful")
                    .statusCode(200).build();
        else {
            log.info("Authentication failed");
            throw new AuthenticationException("Password is wrong");
        }
    }

}
