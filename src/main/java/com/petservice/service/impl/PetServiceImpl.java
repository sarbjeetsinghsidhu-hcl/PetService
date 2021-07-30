package com.petservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.petservice.dto.EditPetDTO;
import com.petservice.dto.PetDetailsRequestDTO;
import com.petservice.dto.PetDetailsResponseDTO;
import com.petservice.entity.UserDetails;
import com.petservice.exception.AuthorizationException;
import com.petservice.exception.NoSuchUserException;
import com.petservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.petservice.dto.PetDetailsDTO;
import com.petservice.entity.PetDetails;
import com.petservice.exception.PetNotFound;
import com.petservice.repository.PetDetailsRepository;
import com.petservice.service.PetService;

@Service
public class PetServiceImpl implements PetService {

    private static final String ERROR_MESSAGE = "User can not be found";

    /**
     *
     */
    @Autowired
    private PetDetailsRepository petDetailsRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public PetDetailsDTO getPetDetails(String userId) {
        // TODO Auto-generated method stub
        return null;
    }


    public PetDetailsResponseDTO addPets(String adminId, PetDetailsRequestDTO petDetailsRequestDTO) {
        UserDetails user = userDetailsRepository.findByUserId(adminId);
        if (user == null) {
            throw new NoSuchUserException(ERROR_MESSAGE);
        }
        if (user.getUserRole() != 'A') {
            throw new AuthorizationException("Not Authorized");
        }
        //Check whether every field is not null


        PetDetails pet = PetDetails.builder()
                .petId(petDetailsRequestDTO.getPetId())
                .petName(petDetailsRequestDTO.getPetName())
                .petAge(petDetailsRequestDTO.getPetAge())
                .petCategory(petDetailsRequestDTO.getPetCategory())
                .petPrice(petDetailsRequestDTO.getPetPrice())
                .petAvailibility(petDetailsRequestDTO.getPetAvailibility())
                .build();

        petDetailsRepository.save(pet);
        return PetDetailsResponseDTO.builder()
                .statusCode(201)
                .message("This pet has been added")
                .petDetailsDTO(PetDetailsDTO.builder()
                        .petId(pet.getPetId())
                        .petName(pet.getPetName())
                        .petAge(pet.getPetAge())
                        .petCategory(pet.getPetCategory())
                        .petPrice(pet.getPetPrice())
                        .petAvailibility(pet.getPetAvailibility())
                        .build()).build();
    }


    public PetDetailsResponseDTO editpet(String adminId, EditPetDTO editPetDTO) {
        UserDetails user = userDetailsRepository.findByUserId(adminId);
        if (user == null) {
            throw new NoSuchUserException(ERROR_MESSAGE);
        }
        if (user.getUserRole() != 'A') {
            throw new AuthorizationException("Not Authorized");
        }






        PetDetails pet = petDetailsRepository.findByPetId(editPetDTO.getPetId()).get();
        pet.setPetId(editPetDTO.getPetId());
        pet.setPetName(editPetDTO.getPetName());
        pet.setPetAge(editPetDTO.getPetAge());
        pet.setPetCategory(editPetDTO.getPetCategory());
        pet.setPetPrice(editPetDTO.getPetPrice());
        pet.setPetAvailibility(editPetDTO.getPetAvailibility());
        return PetDetailsResponseDTO.builder()
                .statusCode(201)
                .message("This account has been updated")
                .petDetailsDTO(PetDetailsDTO.builder()
                        .petId(pet.getPetId())
                        .petName(pet.getPetName())
                        .petAge(pet.getPetAge())
                        .petCategory(pet.getPetCategory())
                        .petPrice(pet.getPetPrice())
                        .petAvailibility(pet.getPetAvailibility())
                        .build()).build();
    }


    @Override
    public List<PetDetailsDTO> getPets(int page) {
        List<PetDetailsDTO> result = new ArrayList<PetDetailsDTO>();
        Page<PetDetails> pets = petDetailsRepository.findAll(PageRequest.of(page, 5, Sort.Direction.ASC, "petName"));
        if (pets.isEmpty()) {
            throw new PetNotFound("Not pet's availabe at this moment.");
        }
        pets.getContent().forEach(pet -> {
            PetDetailsDTO petDetails = new PetDetailsDTO(pet.getPetId(), pet.getPetName(), pet.getPetCategory(),
                    pet.getPetAge(), pet.getPetAvailibility(), pet.getPetPrice());
            result.add(petDetails);
        });
        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.petservice.service.PetService#getPetDetail(java.lang.String)
     */
    @Override
    public PetDetailsDTO getPetDetail(String petId) {
        PetDetailsDTO petDto = null;
        Optional<PetDetails> pet = petDetailsRepository.findByPetId(petId);
        if (pet.isPresent()) {
            petDto = mapToDto(pet.get());
        } else {
            throw new PetNotFound(String.format("Pet Details for pet id {%s} not found.", petId));
        }
        return petDto;
    }

    @Override
    public PetDetailsDTO getPetDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    private PetDetailsDTO mapToDto(PetDetails pet) {
        return new PetDetailsDTO(pet.getPetId(), pet.getPetName(), pet.getPetCategory(),
                pet.getPetAge(), pet.getPetAvailibility(), pet.getPetPrice());
    }
}
