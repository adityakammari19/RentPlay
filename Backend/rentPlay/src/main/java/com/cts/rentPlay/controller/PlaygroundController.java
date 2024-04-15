package com.cts.rentPlay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rentPlay.model.Playground;
import com.cts.rentPlay.service.PlaygroundService;

@RestController
@RequestMapping("/api/playgrounds")
public class PlaygroundController {
		
	@Autowired
	private PlaygroundService playgroundService;
	
	@GetMapping
	public List<Playground> getAllPlaygrounds() {
		return playgroundService.getAllPlaygrounds();
	}
	
	@GetMapping("/{id}")
	public Playground getPlaygroundById(@PathVariable Long id) {
		return playgroundService.getPlaygroundById(id);
	}
	
	@GetMapping("/username/{username}")
	public List<Playground> getPlaygroundByOwnerUsername(@PathVariable String username) {
		return playgroundService.getPlaygroundsByOwnerUsername(username);
	}
	
	@GetMapping("/bylocation")
	public List<Playground> getPlaygroundsByLocation(@RequestParam String location){
		return playgroundService.getPlaygroundsByLocation(location);
	}
	
	@GetMapping("/search")
	public List<Playground> searchPlaygroundsByName(@RequestParam String keyword){
		return playgroundService.searchPlaygroundsByName(keyword);
	}
	
	
	
	
}
