package com.petservice.controller;

import com.petservice.dto.LoginDto;
import com.petservice.dto.LoginResponseDto;
import com.petservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/login")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

	@Autowired
	private final UserService userService;

	@PostMapping("/login")
	@ApiOperation(value = "This method is used to login the customer")
	public ResponseEntity<LoginResponseDto> login (@RequestBody LoginDto loginDto){
		log.info("logging in the user"+loginDto.getUserId());
		return new ResponseEntity<>(userService.login(loginDto),OK);
	}

}
