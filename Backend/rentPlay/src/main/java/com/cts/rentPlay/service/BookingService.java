package com.cts.rentPlay.service;

import java.util.List;

import com.cts.rentPlay.dto.BookingDto;
import com.cts.rentPlay.model.Booking;

public interface BookingService {
	
	public Booking createBooking(BookingDto bookingDto);
	
	public List<Booking> getAllBookings();
	public List<Booking> getBookingsByUser(String username);
	public List<Booking> getBookingsByUsernameAndPlaygroundId(String username, Long playgroundId);
	public List<Booking> getBookingsByOwnerUsername(String username);
	public List<Booking> getBookingsByOwnerUsernameAndPlaygroundId(String username, Long playgroundId);
	
	public Booking acceptBooking(Long bookingId);
	public Booking rejectBooking(Long bookingId);
	public Booking cancelBooking(Long bookingId);
	

}
