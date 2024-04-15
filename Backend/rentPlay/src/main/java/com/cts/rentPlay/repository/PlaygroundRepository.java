package com.cts.rentPlay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.rentPlay.model.Playground;

@Repository
public interface PlaygroundRepository extends JpaRepository<Playground, Long>{
	
	List<Playground> findByLocation(String location);
	
	List<Playground> findByPlaygroundNameContainingIgnoreCase(String name);
	
	List<Playground> findPlaygroundByOwnerId(Long ownerId);
	
	@Query("SELECT p FROM Playground p WHERE lower(p.playgroundName) LIKE lower(concat('%',?1,'%'))")
	List<Playground> searchByName(String keyword);

}
