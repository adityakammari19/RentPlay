package com.cts.rentPlay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.Owner;
import com.cts.rentPlay.model.Playground;
import com.cts.rentPlay.service.OwnerService;


@RestController
@RequestMapping("/api/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/register")
	public ResponseEntity<Owner> registerOwner(@RequestBody Owner owner){
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.createOwner(owner));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner){
		return ResponseEntity.status(HttpStatus.OK).body(ownerService.updateOwner(owner));
	}
	
	@PostMapping("/playgrounds")
	public ResponseEntity<Playground> addPlayground (@RequestBody Playground playground) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.addPlayground(playground));
	}
	
	@DeleteMapping("/playgrounds/{playgroundId}")
	public ResponseEntity<Void> removePlayground(@PathVariable Long playgroundId) {
		 ownerService.removePlayground(playgroundId);
		 return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping("/playgrounds/{playgroundId}")
	public ResponseEntity<Playground> updatePlayground (@PathVariable Long playgroundId,@RequestBody Playground playground) {
		return ResponseEntity.status(HttpStatus.OK).body(ownerService.updatePlayground(playgroundId,playground));
	}
	
	@PutMapping("/bookings/{bookingId}/accept")
	public ResponseEntity<Booking> acceptBooking(@PathVariable Long bookingId){
		return ResponseEntity.status(HttpStatus.OK).body(ownerService.acceptBooking(bookingId));
	}
	
	@PutMapping("/bookings/{bookingId}/reject")
	public ResponseEntity<Booking> rejectBooking(@PathVariable Long bookingId){
		return ResponseEntity.status(HttpStatus.OK).body(ownerService.rejectBooking(bookingId));
	}
}
