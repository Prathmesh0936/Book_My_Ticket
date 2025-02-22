package com.prathmesh.bookmyticket.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.prathmesh.bookmyticket.DAO.Register_User_DAO;
import com.prathmesh.bookmyticket.Repository.User_Repository;
import com.prathmesh.bookmyticket.entity.User;

@Service
public class User_Service {
	
	@Autowired
	private User_Repository user_Repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public User Register_User(Register_User_DAO register_User_DAO) {
		
		if(this.user_Repository.findByEmail(register_User_DAO.getEmail()).isPresent()) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This User is already register with this email");
			
		}
		
		User user = new User();
		
		user.setFirst_name(register_User_DAO.getFirst_name());
		user.setLast_name(register_User_DAO.getLast_name());
		user.setEmail(register_User_DAO.getEmail());
		user.setPassword(passwordEncoder.encode(register_User_DAO.getPassword()));
		user.setRoles(register_User_DAO.getRoles());
		
		this.user_Repository.save(user);
		
		return user;
		
	}
	
}
