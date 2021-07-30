package com.petservice.service;

import com.petservice.dto.LoginDto;
import com.petservice.dto.LoginResponseDto;
import com.petservice.entity.UserDetails;

/**
 * @author Team.
 */
public interface UserService {
    /**
     *
     * @param userId
     * @return
     */
    public UserDetails getUserByUserId(String userId);

    /**
     *
     * @param dto
     * @return
     */
    public LoginResponseDto login(LoginDto dto);
}
