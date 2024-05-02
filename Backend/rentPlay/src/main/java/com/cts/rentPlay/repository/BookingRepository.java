package com.cts.rentPlay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.rentPlay.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findByUserId(Long userId);

//	@Query("SELECT b from Booking b JOIN b.user u JOIN b.playground p WHERE u.userId = ?1 AND p.playgroundId = ?2")
//	@Query("select b1_0.booking_id,b1_0.end_time,b1_0.playground_id,b1_0.start_time,b1_0.status,b1_0.total_price,b1_0.user_id from Booking b1_0 left join User u1_0 on u1_0.user_id=b1_0.user_id left join Playground p1_0 on p1_0.playground_id=b1_0.playground_id where u1_0.user_id=?1 and p1_0.playground_id=?2")
//	@Query("select b1_0 from Booking b1_0 left join User u1_0 on u1_0.userId=b1_0.user.userId left join Playground p1_0 on p1_0.playgroundId=b1_0.playground.playgroundId where u1_0.userId=?1 and p1_0.playgroundId=?2")
//	@Query("SELECT b from Booking b  WHERE b.user.userId = ?1 AND b.playground.playgroundId = ?2")
//	List<Booking> findBookingsByUserIdAndPlaygroundId(Long userId, Long playgroundId);
	
	List<Booking> findByUserIdAndPlaygroundId(Long userId, Long playgroundId);
	
	@Query("SELECT b from Booking b JOIN Playground p ON b.playgroundId = p.playgroundId WHERE p.ownerId = :ownerId")
	List<Booking> findBookingsByOwnerId(Long ownerId);
	
	@Query("SELECT b from Booking b JOIN Playground p ON b.playgroundId = p.playgroundId WHERE b.playgroundId = ?1 AND p.ownerId = ?2")
	List<Booking> findBookingsByPlaygroundIdAndOwnerId(Long playgroundId, Long ownerId);
	
//	List<Booking> findByOwnerIdAndPlaygroundId(Long ownerId, Long playgroundId);
	

}
