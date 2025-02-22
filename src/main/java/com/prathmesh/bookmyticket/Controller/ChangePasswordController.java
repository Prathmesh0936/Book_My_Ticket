package com.prathmesh.bookmyticket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathmesh.bookmyticket.DAO.ChangePasswordDAO;
import com.prathmesh.bookmyticket.DAO.CheckOtpDAO;
import com.prathmesh.bookmyticket.DAO.SendEmailDAO;
import com.prathmesh.bookmyticket.Service.ChangeUserPasswordService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users/changepassword")
public class ChangePasswordController {
	
	@Autowired
	private ChangeUserPasswordService changeUserPasswordService;

	@PutMapping("")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDAO changePasswordDAO, HttpSession session){
		
		String email = (String) session.getAttribute("email");
		
		return ResponseEntity.ok(this.changeUserPasswordService.chagePassword(changePasswordDAO, email));
		
	}
	
	@PostMapping("/email")
	public ResponseEntity<?> send(@RequestBody SendEmailDAO sendEmailDAO , HttpSession session){
		
		session.setAttribute("email", sendEmailDAO.getEmail());
		
		return ResponseEntity.ok(this.changeUserPasswordService.sendEmail(sendEmailDAO));
		
	}
	
	@PostMapping("/check")
	public ResponseEntity<?> checkOTP(@RequestBody CheckOtpDAO checkOtpDAO){
		
		return ResponseEntity.ok(this.changeUserPasswordService.checkOTP(checkOtpDAO));
		
	}
	
}
