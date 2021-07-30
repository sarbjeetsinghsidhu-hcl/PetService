package com.petservice.repository;

import com.petservice.entity.PetOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PetOrderDetails,Long> {
}
