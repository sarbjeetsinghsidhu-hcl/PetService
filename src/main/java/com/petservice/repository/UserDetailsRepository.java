package com.petservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petservice.entity.UserDetails;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {


    public UserDetails findByUserId(String userId);

    boolean existsUserDetailsByUserId(String userId);

    
    public Page<UserDetails> findByUserId(final String userId, Pageable pageable);
}
