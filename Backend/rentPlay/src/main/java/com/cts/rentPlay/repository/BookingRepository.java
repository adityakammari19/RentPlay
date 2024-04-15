package com.cts.rentPlay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.rentPlay.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findByUserUsername(String username);

	@Query("SELECT b from Booking b WHERE b.user = ?1 AND b.playground = ?2")
	List<Booking> findByUserAndPlayground(Long userId, Long playgroundId);
	
	@Query("SELECT b from Booking b JOIN b.playground p WHERE p.ownerId = :ownerId")
	List<Booking> findBookingsByOwnerId(Long ownerId);
	
	@Query("SELECT b from Booking b JOIN Playground p ON b.playground.playgroundId = p.playgroundId WHERE p.playgroundId = ?1 AND p.ownerId = ?2")
	List<Booking> findBookingsByPlaygroundIdAndOwnerId(Long playgroundId, Long ownerId);
	

}
