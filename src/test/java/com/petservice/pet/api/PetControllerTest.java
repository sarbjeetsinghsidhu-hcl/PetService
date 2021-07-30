package com.petservice.pet.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.petservice.PetServiceApplication;
import com.petservice.controller.PetController;
import com.petservice.dto.PetDetailsDTO;
import com.petservice.service.PetService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PetController.class)
@ContextConfiguration(classes = PetServiceApplication.class)
class PetControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PetService petService;

	@Test
	void testGetPets() throws Exception {
		PetDetailsDTO dto = new PetDetailsDTO();
		dto.setPetId("pet-02");
		dto.setPetAvailibility(1);
		dto.setPetName("test");
		List<PetDetailsDTO> mockPetDetails = new ArrayList<PetDetailsDTO>();
		mockPetDetails.add(dto);
		when(petService.getPets(0)).thenReturn(mockPetDetails);
		mockMvc.perform(get("/api/v1/pets?page=0")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].petId", Matchers.is("pet-02")));
	}

	@Test
	void testGetPet() throws Exception {
		when(petService.getPetDetail("pet1")).thenReturn(getPetDetails());
		mockMvc.perform(get("/api/v1/pets/pet1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.petId", Matchers.is("pet-01")));
	}

	private PetDetailsDTO getPetDetails() {
		PetDetailsDTO dto = new PetDetailsDTO();
		dto.setPetId("pet-01");
		dto.setPetAvailibility(1);
		dto.setPetName("test");
		return dto;
	}
}
