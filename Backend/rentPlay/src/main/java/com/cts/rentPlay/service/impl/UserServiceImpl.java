package com.cts.rentPlay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.rentPlay.dto.BookingDto;
import com.cts.rentPlay.exception.ConflictException;
import com.cts.rentPlay.exception.UserNotFoundException;
import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.User;
import com.cts.rentPlay.repository.UserRepository;
import com.cts.rentPlay.service.BookingService;
import com.cts.rentPlay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookingService bookingService;
	
	
	@Override
	public User createUser(User user) {
		if(userRepository.existsByUsername(user.getUsername())) {
			throw new ConflictException("Username already exists:"+ user.getUsername());
		}
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ConflictException("Email already exists:"+ user.getEmail());
		}
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser != null) {
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setPhoneNumber(user.getPhoneNumber());
			return userRepository.save(existingUser);
		}
		else {
			throw new UserNotFoundException("User not found with username"+user.getUsername());
		}
		
	}
	
	@Override
	public User getUserByUsername(String username) {
		User user  = userRepository.findByUsername(username);
		if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with username : "+username);
        }
	}
	@Override
	public Booking createBooking(BookingDto bookingDto) {
		return bookingService.createBooking(bookingDto);
	}

	@Override
	public Booking cancelBooking(Long bookingId) {
		return bookingService.cancelBooking(bookingId);
	}



}
