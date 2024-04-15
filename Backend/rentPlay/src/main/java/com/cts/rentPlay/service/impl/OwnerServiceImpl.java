package com.cts.rentPlay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.rentPlay.exception.ConflictException;
import com.cts.rentPlay.exception.UserNotFoundException;
import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.Owner;
import com.cts.rentPlay.model.Playground;
import com.cts.rentPlay.repository.OwnerRepository;
import com.cts.rentPlay.service.BookingService;
import com.cts.rentPlay.service.OwnerService;
import com.cts.rentPlay.service.PlaygroundService;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private PlaygroundService playgroundService;

	@Autowired
	private BookingService bookingService;

	@Override
	public Owner createOwner(Owner owner) {
		if (ownerRepository.existsByUsername(owner.getUsername())) {
			throw new ConflictException("Username already exists:" + owner.getUsername());
		}
		if (ownerRepository.existsByEmail(owner.getEmail())) {
			throw new ConflictException("Email already exists:" + owner.getEmail());
		}
		return ownerRepository.save(owner);
	}

	@Override
	public Owner updateOwner(Owner owner) {
		Owner existingOwner = ownerRepository.findByUsername(owner.getUsername());
		if (existingOwner != null) {
			existingOwner.setEmail(owner.getEmail());
			existingOwner.setPassword(owner.getPassword());
			existingOwner.setPhoneNumber(owner.getPhoneNumber());
			return ownerRepository.save(existingOwner);
		} else {
			throw new UserNotFoundException("Owner not found with username" + owner.getUsername());
		}
	}

	@Override
	public Playground addPlayground(Playground playground) {
		return playgroundService.createPlayground(playground);
	}

	@Override
	public void removePlayground(Long playgroundId) {
		playgroundService.deletePlayground(playgroundId);
	}

	@Override
	public Playground updatePlayground(Long playgroundId, Playground updatedPlayground) {
		return playgroundService.updatePlayground(playgroundId, updatedPlayground);
	}

	@Override
	public Booking acceptBooking(Long bookingId) {
		return bookingService.acceptBooking(bookingId);

	}

	@Override
	public Booking rejectBooking(Long bookingId) {
		return bookingService.rejectBooking(bookingId);

	}

	@Override
	public Owner getOwnerByUsername(String username) {
		return ownerRepository.findByUsername(username);
	}

}
