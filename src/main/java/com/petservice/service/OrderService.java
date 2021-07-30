package com.petservice.service;

import com.petservice.dto.OrderRequestDto;
import com.petservice.dto.OrderResponseDto;

/**
 * @author Team.
 */
public interface OrderService {
    /**
     *
     * @param orderRequestDto
     * @return
     */
    public OrderResponseDto buyPet(OrderRequestDto orderRequestDto);
}
