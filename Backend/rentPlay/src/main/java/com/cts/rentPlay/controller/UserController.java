package com.cts.rentPlay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rentPlay.dto.BookingDto;
import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.User;
import com.cts.rentPlay.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}

	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@PostMapping("/booking")
	public ResponseEntity<Booking> createBooking(@RequestBody BookingDto bookingDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createBooking(bookingDto));
	}

	@PutMapping("/bookings/{bookingId}/cancel")
	public ResponseEntity<Booking> cancelBooking(Long bookingId) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.cancelBooking(bookingId));
	}

}
