package com.cts.rentPlay.service;

import com.cts.rentPlay.model.Booking;
import com.cts.rentPlay.model.Owner;
import com.cts.rentPlay.model.Playground;

public interface OwnerService {
	
	public Owner getOwnerByUsername(String username);
	
	public Owner createOwner(Owner owner);
	public Owner updateOwner(Owner owner);
	
	public Playground addPlayground(Playground playground);
	public void removePlayground(Long playgroundId);
	public Playground updatePlayground(Long playgroundId, Playground updatedPlayground);
	
	public Booking acceptBooking(Long bookingId);
	public Booking rejectBooking(Long bookingId);

}
