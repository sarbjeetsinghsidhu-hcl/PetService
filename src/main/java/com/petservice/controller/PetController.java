package com.petservice.controller;

import java.util.List;
import java.util.Optional;

import com.petservice.dto.OrderRequestDto;
import com.petservice.dto.OrderResponseDto;
import com.petservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petservice.dto.PetDetailsDTO;
import com.petservice.exception.ErrorResponse;
import com.petservice.service.PetService;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Team-2
 *
 */
@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);
	
	/**
	 * 
	 */
	@Autowired
	private PetService petService;
	@Autowired
	private OrderService orderService;
	/**
	 * Accept the customer id and returns list of favorite accounts from database.
	 * 
	 * @param page - Current page number for pagination
	 * @return {List<FavouriteAccount>} - List of Favorite accounts.
	 */
	@ApiOperation(value = "Get list of pets", response = PetDetailsDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successfull operation", response = PetDetailsDTO.class),
		@ApiResponse(code = 404, message = "Favourites not found", response = ErrorResponse.class)
	})
	@GetMapping("")
	public List<PetDetailsDTO> getPets(@RequestParam("page") Optional<Integer> page){
		LOGGER.info("Getting pets.");
		return petService.getPets(page.orElse(0));		
	}
	
	@ApiOperation(value = "Get pet details", response = PetDetailsDTO.class)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Successfull operation", response = PetDetailsDTO.class),
		@ApiResponse(code = 404, message = "Pet not found", response = ErrorResponse.class),		
	})
	@GetMapping("/{petId}")
	public PetDetailsDTO getPet(@PathVariable("petId") @NotNull String petId){
		return petService.getPetDetail(petId);
	}

	@PostMapping("/order")
	public OrderResponseDto purchasePet(@RequestBody OrderRequestDto orderRequestDto) {
		return orderService.buyPet(orderRequestDto);
	}
	
}
