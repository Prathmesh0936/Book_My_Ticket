package com.prathmesh.bookmyticket.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathmesh.bookmyticket.DAO.Add_Bus_DAO;
import com.prathmesh.bookmyticket.DAO.ScheduleDTO;
import com.prathmesh.bookmyticket.DAO.Update_Bus_DAO;
import com.prathmesh.bookmyticket.Repository.Bus_Repository;
import com.prathmesh.bookmyticket.entity.Buses;
import com.prathmesh.bookmyticket.entity.Schedule;

@Service
public class Bus_Service {

	@Autowired
	private Bus_Repository bus_Repository;
	
	public Buses Add_new_Bus(Add_Bus_DAO add_Bus_DAO) {
	    Buses bus = new Buses();
	    bus.setName(add_Bus_DAO.getName());
	    bus.setSource(add_Bus_DAO.getSource());
	    bus.setDestination(add_Bus_DAO.getDestination());
	    bus.setOperator(add_Bus_DAO.getOperator());
	    bus.setTotal_seats(add_Bus_DAO.getTotal_seats());
	    bus.setAmenities(add_Bus_DAO.getAmenities());
	    bus.setJourney_duration(add_Bus_DAO.getJourney_duration());

	    // Convert ScheduleDTO to Schedule entity
	    List<Schedule> scheduleList = new ArrayList<>();
	    if (add_Bus_DAO.getSchedules() != null) {
	        for (ScheduleDTO dto : add_Bus_DAO.getSchedules()) {
	            Schedule schedule = new Schedule();
	            schedule.setDate(dto.getDate());
	            schedule.setTime(dto.getTime());
	            schedule.setFare(dto.getFare());
	            schedule.setAvailable_seats(dto.getAvailableSeats());
	            schedule.setBus(bus);  // Link to parent bus
	            scheduleList.add(schedule);
	        }
	    }

	    bus.setSchedules(scheduleList);
	    return bus_Repository.save(bus);
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
	
	 // Method to find buses by source and destination
    public List<Buses> findBusesBySourceAndDestination(String source, String destination) {
        return bus_Repository.findBySourceAndDestination(source, destination);
    }
	
}
