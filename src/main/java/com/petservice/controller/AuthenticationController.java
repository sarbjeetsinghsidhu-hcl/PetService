package com.petservice.controller;


import com.petservice.config.JwtTokenUtil;
import com.petservice.dto.AuthToken;
import com.petservice.dto.GenerateTokenDto;
import com.petservice.entity.UserDetails;
import com.petservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    private final UserService userService;

    @PostMapping(value = "/generate-token")
    public ResponseEntity<AuthToken> generateToken(@RequestBody GenerateTokenDto dto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserId(), dto.getPassword()));
        final UserDetails user = userService.getUserByUserId(dto.getUserId());
        final String token = jwtTokenUtil.generateToken(user);
        return new ResponseEntity<>(AuthToken.builder()
                .email(user.getUserId())
                .token(token).build(), OK);
    }

}