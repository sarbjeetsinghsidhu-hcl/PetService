package com.petservice.service.impl;

import com.petservice.dto.OrderRequestDto;
import com.petservice.dto.OrderResponseDto;
import com.petservice.entity.PetDetails;
import com.petservice.entity.PetOrderDetails;
import com.petservice.entity.UserDetails;
import com.petservice.exception.EmptyFieldException;
import com.petservice.exception.NoSuchUserException;
import com.petservice.exception.PetNotFound;
import com.petservice.exception.PetSoldOutException;
import com.petservice.repository.PetDetailsRepository;
import com.petservice.repository.UserDetailsRepository;
import com.petservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PetDetailsRepository petDetailsRepository;
    @Autowired
    private UserDetailsRepository repository;
    @Override
    public OrderResponseDto buyPet(OrderRequestDto orderRequestDto) {
        if(orderRequestDto.getPetId() == null || orderRequestDto.getUserId() == null)
            throw new EmptyFieldException("One or more fields are empty");
        UserDetails user = repository.findByUserId(orderRequestDto.getUserId());
        if(user == null)
            throw new NoSuchUserException("User cannot be found");
        Optional<PetDetails> petDetails = petDetailsRepository.findByPetId(orderRequestDto.getPetId());
        PetDetails details = null;
        if(petDetails.isPresent())
            details = petDetails.get();
        else
            throw new PetNotFound("Pet cannot be found");
        if(details.getPetAvailibility()==0)
            throw new PetSoldOutException("This Pet is sold out and not available for purchase");
        PetOrderDetails petOrderDetails = PetOrderDetails.builder()
                .petDetails(details)
                .userDetails(user)
                .purchasedOn(LocalDate.now()).build();
        user.setPetOrderDetails(Collections.singletonList(petOrderDetails));
        details.setPetOrderDetails(Collections.singletonList(petOrderDetails));
        repository.save(user);
        petDetailsRepository.save(details);
        return OrderResponseDto.builder()
                .message("This pet has been purchased")
                .petAge(details.getPetAge())
                .petCategory(details.getPetCategory())
                .petId(details.getPetId())
                .petName(details.getPetName())
                .petPrice(details.getPetPrice())
                .statusCode(200)
                .userName(user.getUserName()).build();
    }
}
