package com.cts.rentPlay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.rentPlay.dto.BookingDto;
import com.cts.rentPlay.exception.ResourceNotFoundException;
import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.Playground;
import com.cts.rentPlay.model.User;
import com.cts.rentPlay.repository.BookingRepository;
import com.cts.rentPlay.service.BookingService;
import com.cts.rentPlay.service.OwnerService;
import com.cts.rentPlay.service.PlaygroundService;
import com.cts.rentPlay.service.UserService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PlaygroundService playgroundService;
	
	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> getBookingsByUser(String username) {
		Long userId = userService.getUserByUsername(username).getUserId();
		return bookingRepository.findByUserId(userId);
	}

	@Override
	public List<Booking> getBookingsByUsernameAndPlaygroundId(String username, Long playgroundId) {
		Long userId = userService.getUserByUsername(username).getUserId();	
		return bookingRepository.findByUserIdAndPlaygroundId(userId, playgroundId);
	}

	@Override
	public List<Booking> getBookingsByOwnerUsername(String Username) {
		Long ownerId = ownerService.getOwnerByUsername(Username).getOwnerId();
		return bookingRepository.findBookingsByOwnerId(ownerId);
	}

	@Override
	public List<Booking> getBookingsByOwnerUsernameAndPlaygroundId( String username, Long playgroundId) {
		Long ownerId = ownerService.getOwnerByUsername(username).getOwnerId();
		return bookingRepository.findBookingsByPlaygroundIdAndOwnerId(ownerId, playgroundId);
	}

	@Override
	public Booking acceptBooking(Long bookingId) {

		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			Booking booking = optionalBooking.get();
			booking.setStatus("Confirmed");
			bookingRepository.save(booking);
			return booking;
		}
		else {
			throw new ResourceNotFoundException("Booking not with Id:"+ bookingId);
		}
	}

	@Override
	public Booking rejectBooking(Long bookingId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			Booking booking = optionalBooking.get();
			booking.setStatus("Rejected");
			bookingRepository.save(booking);
			return booking;
		}
		else {
			throw new ResourceNotFoundException("Booking not with Id:"+ bookingId);
		}
	}

	@Override
	public Booking cancelBooking(Long bookingId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			Booking booking = optionalBooking.get();
			if(booking.getStatus() == "pending") {
				
				booking.setStatus("canceled");
			}
			bookingRepository.save(booking);
			return booking;
		}
		else {
			throw new ResourceNotFoundException("Booking not with Id:"+ bookingId);
		}
	}

	@Override
	public Booking createBooking(BookingDto bookingDto) {
//		booking.setPlayground(playgroundService.getPlaygroundById(booking.getPlayground().getPlaygroundId()));
		Playground playground = playgroundService.getPlaygroundById(bookingDto.getPlaygroundId());
		User user = userService.getUserByUsername(bookingDto.getUsername());
		Long slotsBooked = bookingDto.getSlotsBooked();
		Double totalPrice = slotsBooked * playground.getPricePerSlot();
		Booking booking = new Booking();
		booking.setPlaygroundId(bookingDto.getPlaygroundId());
		booking.setUserId(user.getUserId());
		booking.setStatus("Pending");
		booking.setStartTime(bookingDto.getStartTime());
		booking.setEndTime(bookingDto.getEndTime());
		booking.setTotalPrice(totalPrice);
		
		
		return bookingRepository.save(booking);
	}

}
