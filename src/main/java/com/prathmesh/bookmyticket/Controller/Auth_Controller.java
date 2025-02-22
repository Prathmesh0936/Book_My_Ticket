package com.prathmesh.bookmyticket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathmesh.bookmyticket.DAO.Login_DAO;
import com.prathmesh.bookmyticket.DAO.Register_User_DAO;
import com.prathmesh.bookmyticket.Service.User_Service;

@Controller
@RequestMapping("/auth")
public class Auth_Controller {
	
	@Autowired
	private User_Service user_Service;

	@PostMapping("/register")
	public ResponseEntity<?> Register_User(@RequestBody Register_User_DAO register_User_DAO){
		
		return ResponseEntity.ok(this.user_Service.Register_User(register_User_DAO));
		
	}
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login_DAO login_DAO){
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login_DAO.getEmail(), login_DAO.getPassword()));
	
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return  ResponseEntity.ok("User Logged In!!!");
		
	}
	
}
