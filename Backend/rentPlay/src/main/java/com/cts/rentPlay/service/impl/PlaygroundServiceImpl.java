package com.cts.rentPlay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.rentPlay.exception.ResourceNotFoundException;
import com.cts.rentPlay.model.Playground;
import com.cts.rentPlay.repository.PlaygroundRepository;
import com.cts.rentPlay.service.OwnerService;
import com.cts.rentPlay.service.PlaygroundService;

@Service
public class PlaygroundServiceImpl implements PlaygroundService {

	@Autowired
	private PlaygroundRepository playgroundRepository;
	
	@Autowired
	private OwnerService ownerService;
	
	@Override
	public List<Playground> getAllPlaygrounds() {
		return playgroundRepository.findAll();
	}

	@Override
	public Playground getPlaygroundById(Long id) {
		return playgroundRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Playground not found with id:"+ id));
	}

	@Override
	public List<Playground> getPlaygroundsByLocation(String location) {
		return playgroundRepository.findByLocation(location);
	}
	
	@Override
	public List<Playground> getPlaygroundsByPlaygroundName(String name) {
		return playgroundRepository.findByPlaygroundNameContainingIgnoreCase(name);
	}

	@Override
	public List<Playground> searchPlaygroundsByName(String keyword) {
		return playgroundRepository.searchByName(keyword);
	}

	@Override
	public List<Playground> getPlaygroundsByOwnerUsername(String username) {
		Long ownerId = ownerService.getOwnerByUsername(username).getOwnerId();
		return playgroundRepository.findPlaygroundByOwnerId(ownerId);
	}

	@Override
	public Playground createPlayground(Playground playground) {
		return playgroundRepository.save(playground);
	}

	@Override
	public void deletePlayground(Long playgroundId) {
		playgroundRepository.deleteById(playgroundId);
	}

	@Override
	public Playground updatePlayground(Long playgroundId, Playground updatedPlayground) {
		
		Optional<Playground> optionalPlayground = playgroundRepository.findById(playgroundId);
		if(optionalPlayground.isPresent()) {
			Playground existingPlayground = optionalPlayground.get();
			existingPlayground.setPlaygroundName(updatedPlayground.getPlaygroundName());
			//update other fields
			return playgroundRepository.save(existingPlayground);
		}
		else {
			throw new ResourceNotFoundException("Playground not found with id:"+ playgroundId);
		}
	}


}
