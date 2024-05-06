package com.cts.rentPlay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.rentPlay.model.MyUserDetails;
import com.cts.rentPlay.model.User;
import com.cts.rentPlay.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user:"+ username);
        }
         
        return new MyUserDetails(user);
	}

}
