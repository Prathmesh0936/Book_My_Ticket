package com.prathmesh.bookmyticket.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prathmesh.bookmyticket.DAO.Login_DAO;
import com.prathmesh.bookmyticket.DAO.Register_User_DAO;
import com.prathmesh.bookmyticket.Repository.User_Repository;
import com.prathmesh.bookmyticket.Service.MyUserDetialsService;
import com.prathmesh.bookmyticket.Service.User_Service;
import com.prathmesh.bookmyticket.entity.User;

@Controller
@RequestMapping("/api/auth")
public class Auth_Controller {
	
	  @Autowired
	   private User_Repository user_Repository;
	
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
	
	 @Autowired
	    private MyUserDetialsService myUserDetailsService;

	    @GetMapping("/role")
	    public ResponseEntity<?> getUserRole(@RequestParam String email) {
	        User user = myUserDetailsService.getUserByEmail(email);
	        Map<String, Object> response = new HashMap<>();
	        response.put("roles", user.getRoles());
	        response.put("email", user.getEmail());
	        response.put("id", user.getId());
	        return ResponseEntity.ok(response);
	    }
	

	    @GetMapping("/roles/{email}")
	    public ResponseEntity<?> getRoles(@PathVariable String email) {
	        return user_Repository.findByEmail(email)
	                .map(user -> ResponseEntity.ok(user.getRoles()))
	                .orElse(ResponseEntity.notFound().build());
	    }
	
}
