package com.prathmesh.bookmyticket.Service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prathmesh.bookmyticket.Repository.User_Repository;
import com.prathmesh.bookmyticket.entity.User;

@Service
public class MyUserDetialsService  implements UserDetailsService{

	@Autowired
	private User_Repository user_Repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		return this.user_Repository.findByEmail(username)
				.map( user -> {
					
					return new User( 	
							
							user.getEmail(),
							user.getPassword(),
							user.getRoles().stream()
							.map( role -> new SimpleGrantedAuthority(role))
							.collect(Collectors.toList())
							);
					
				}).orElseThrow(
						
						() -> {
							
							throw new UsernameNotFoundException("User with this email not Found!!!");
							
						}
						
						);
	}

}
