package com.cts.rentPlay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/user/{username}")
	public List<Booking> getBookingsByUser(@PathVariable String username){
		return bookingService.getBookingsByUser(username);
	}
	
	@GetMapping("/user/{username}/playground/{playgroundId}")
	public List<Booking> getBookingsByUsernameandPlaygroundId(@PathVariable String username,long playgroundId){
		return bookingService.getBookingsByUsernameAndPlaygroundId(username,playgroundId);
	}
	
	@GetMapping("/owner/{username}")
	public List<Booking> getBookingsByOwner(@PathVariable String username){
		return bookingService.getBookingsByOwnerUsername(username);
	}
	
	@GetMapping("/owner/{username}/playground/{playgroundId}")
	public List<Booking> getBookingsByOwnerUsernameandPlaygroundId(@PathVariable String username,long playgroundId){
		return bookingService.getBookingsByOwnerUsernameAndPlaygroundId(username, playgroundId);
	}
	





	
}
