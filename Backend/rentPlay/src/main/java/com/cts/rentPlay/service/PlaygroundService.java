package com.cts.rentPlay.service;

import java.util.List;

import com.cts.rentPlay.model.Playground;

public interface PlaygroundService {
	
	public List<Playground> getAllPlaygrounds();
	public Playground getPlaygroundById(Long id);
	public List<Playground> getPlaygroundsByOwnerUsername(String username);
	public List<Playground> getPlaygroundsByLocation(String location);
	public List<Playground> getPlaygroundsByPlaygroundName(String name);
	public List<Playground> searchPlaygroundsByName(String keyword);
	
	public Playground createPlayground(Playground playground);
	public void deletePlayground(Long playgroundId);
	public Playground updatePlayground(Long playgroundId, Playground updatedPlayground);

}
