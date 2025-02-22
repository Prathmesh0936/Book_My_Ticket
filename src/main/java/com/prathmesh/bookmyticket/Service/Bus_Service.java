package com.prathmesh.bookmyticket.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathmesh.bookmyticket.DAO.Add_Bus_DAO;
import com.prathmesh.bookmyticket.DAO.Update_Bus_DAO;
import com.prathmesh.bookmyticket.Repository.Bus_Repository;
import com.prathmesh.bookmyticket.entity.Buses;

@Service
public class Bus_Service {

	@Autowired
	private Bus_Repository bus_Repository;
	
	public Buses Add_new_Bus(Add_Bus_DAO add_Bus_DAO) {
		
		Buses buses = new Buses();
		
		buses.setName(add_Bus_DAO.getName());
		buses.setSource(add_Bus_DAO.getSource());
		buses.setDestination(add_Bus_DAO.getDestination());
		buses.setOperator(add_Bus_DAO.getOperator());
		buses.setTotal_seats(add_Bus_DAO.getTotal_seats());;
		buses.setAmenities(add_Bus_DAO.getAmenities());
		buses.setJourney_duration(add_Bus_DAO.getJourney_duration());
		
		this.bus_Repository.save(buses);
		
		return buses;
		
	}
	
	public List<Buses> ViewAllBuses(){
		
		List<Buses> bus = new  ArrayList<Buses>();
		
		bus = this.bus_Repository.findAll();
		
		return bus;
	}
	
	public Buses ViewById(Integer id) {
		
		Buses buses = new Buses();
		
		buses = this.bus_Repository.findById(id).orElse(null);
		
		return buses;
		
	}
	
	public Buses DeleteById(Integer id) {
		
		Buses buses = new Buses();
		
		buses = this.ViewById(id);
		
	    this.bus_Repository.delete(buses);
		
		return buses;
		
	}
	
	public Buses UpdateById(Integer id, Update_Bus_DAO update_Bus_DAO) {
		
		Buses buses = this.ViewById(id);
		
		if(update_Bus_DAO.getName() != null) {
			
			buses.setName(update_Bus_DAO.getName());
			
		}
		
		if(update_Bus_DAO.getSource() != null) {
			
			buses.setSource(update_Bus_DAO.getSource());
			
		}
		
		if(update_Bus_DAO.getDestination() != null) {
			
			buses.setDestination(update_Bus_DAO.getDestination());
			
		}
		
		if(update_Bus_DAO.getOperator() != null) {
			
			buses.setOperator(update_Bus_DAO.getOperator());
			
		}
		
		if(update_Bus_DAO.getTotal_seats() != null) {
			
			buses.setTotal_seats(update_Bus_DAO.getTotal_seats());
			
		}
		
		if(update_Bus_DAO.getAmenities() != null) {
			
			buses.setAmenities(update_Bus_DAO.getAmenities());
			
		}
		
		if(update_Bus_DAO.getJourney_duration() != null) {
			
			buses.setJourney_duration(update_Bus_DAO.getJourney_duration());
			
		}
		
		this.bus_Repository.save(buses);
		
		return buses;
		
	}
	
}
