package com.prathmesh.bookmyticket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathmesh.bookmyticket.DAO.Add_Bus_DAO;
import com.prathmesh.bookmyticket.DAO.Update_Bus_DAO;
import com.prathmesh.bookmyticket.Service.Bus_Service;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/buseses")
public class Bus_Controller {

	@Autowired
	private Bus_Service bus_Service;
	
	@PostMapping("")
	public ResponseEntity<?> AddBus(@RequestBody @Valid Add_Bus_DAO add_Bus_DAO){
		
		return ResponseEntity.ok(this.bus_Service.Add_new_Bus(add_Bus_DAO));
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> ViewAllBus(){
		
		return ResponseEntity.ok(this.bus_Service.ViewAllBuses());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ViewBusById(@PathVariable Integer id){
		
		return ResponseEntity.ok(this.bus_Service.ViewById(id));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteBus(@PathVariable Integer id){
		
		return ResponseEntity.ok(this.bus_Service.DeleteById(id));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateBus(@PathVariable Integer id, @RequestBody Update_Bus_DAO update_Bus_DAO){
		
		return ResponseEntity.ok(this.bus_Service.UpdateById(id, update_Bus_DAO));
		
	}
	
}
