package com.cts.rentPlay.service;

import com.cts.rentPlay.dto.BookingDto;
import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.User;

public interface UserService {
	
	public User createUser(User user);
	public User updateUser(User user);
	
	public User getUserByUsername(String username);
	
	public Booking createBooking(BookingDto bookingDto);
	public Booking cancelBooking(Long bookingId);
	

}
