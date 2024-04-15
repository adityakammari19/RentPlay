package com.cts.rentPlay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.rentPlay.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

	Owner findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
	
	

}
