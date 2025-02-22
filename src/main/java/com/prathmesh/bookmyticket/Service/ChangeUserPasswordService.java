package com.prathmesh.bookmyticket.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.prathmesh.bookmyticket.DAO.ChangePasswordDAO;
import com.prathmesh.bookmyticket.DAO.CheckOtpDAO;
import com.prathmesh.bookmyticket.DAO.SendEmailDAO;
import com.prathmesh.bookmyticket.Repository.User_Repository;
import com.prathmesh.bookmyticket.entity.User;

@Service
public class ChangeUserPasswordService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private User_Repository user_Repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	Random random = new Random();
	
	int OTP = 0;
	
	public User chagePassword(ChangePasswordDAO changePasswordDAO, String email) {
		
		User user = new User();
		
		user = this.user_Repository.findByEmail(email).orElse(null);
		
		if(changePasswordDAO.getPassword().equals(changePasswordDAO.getConfirmPassword())) {
			
			user.setPassword(passwordEncoder.encode(changePasswordDAO.getPassword()));
			
			this.user_Repository.save(user);
			
		}else {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password and Confirm password does not Matched");
			
		}
		
		return user;
		
	}
	
	public String sendEmail(SendEmailDAO sendEmailDAO) {
		
		if(this.user_Repository.findByEmail(sendEmailDAO.getEmail()).isPresent()) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			OTP = random.nextInt(10000);
			
			message.setFrom("prathmeshkshirsagar259@gmail.com");
			message.setTo(sendEmailDAO.getEmail());
			message.setSubject("OTP For Verification");
			message.setText("Your One-Time Password (OTP) for securely resetting your account password is: " + OTP + 
					"\n\nThis OTP is valid for 10 minutes. For security reasons, please do not share this code with anyone.\n\n" + 
					"If you did not request a password reset, please contact our support team immediately at prathmeshkshirsagar259@gmail.com\n\n");
			emailSender.send(message);
			
			return "Email Send";
			
		}else {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Email is not registered");
			
		}
		
	}
	
	public String checkOTP(CheckOtpDAO checkOtpDAO) {
		
		if(this.OTP == checkOtpDAO.getOTP()) {
			
			return "OTP Matched";
			
		}else {
			
			return "OTP Not Matched";
			
		}
		
	}
	
}
