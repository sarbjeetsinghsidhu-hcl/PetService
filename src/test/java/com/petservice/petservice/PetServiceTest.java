package com.petservice.petservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.petservice.dto.PetDetailsDTO;
import com.petservice.entity.PetDetails;
import com.petservice.exception.PetNotFound;
import com.petservice.repository.PetDetailsRepository;
import com.petservice.service.impl.PetServiceImpl;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {
	
	@InjectMocks
	private PetServiceImpl favService;
	
	@Mock
	private PetDetailsRepository dao;


	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetPetDetails() {
		PetDetails petDetails =  PetDetails.builder().id(1).petName("pet-1").petCategory("dog").build();
		List<PetDetails> petList = Arrays.asList(petDetails);
		
		Page<PetDetails> page = new PageImpl<>(petList);		
		when(dao.findAll(PageRequest.of(0, 5, Sort.Direction.ASC, "petName"))).thenReturn(page);		
		List<PetDetailsDTO> favAccountList = favService.getPets(0);
		assertEquals(1, favAccountList.size());
		verify(dao, times(1)).findAll( PageRequest.of(0, 5, Sort.Direction.ASC, "petName"));
	}
	
	@Test
	void testGetPetDetails_Exception() {
		PetNotFound petNotFound = new PetNotFound("Not pet's availabe at this moment.");
		List<PetDetails> petList = new ArrayList<>();	
		Page<PetDetails> page = new PageImpl<>(petList);		
		when(dao.findAll(PageRequest.of(0, 5, Sort.Direction.ASC, "petName"))).thenReturn(page);
		Exception actualEx = assertThrows(PetNotFound.class, ()->{
			dao.findAll(PageRequest.of(0, 5, Sort.Direction.ASC, "petName"));
		});
		assertEquals(petNotFound.getMessage(), actualEx.getMessage());
	}
}
