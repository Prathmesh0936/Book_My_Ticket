package com.prathmesh.bookmyticket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.Booking;
import com.prathmesh.bookmyticket.entity.Schedule;

@Repository
public interface Booking_Repository extends JpaRepository<Booking, Integer>{

	List<Booking> findBySchedule(Schedule schedule);
	
	@EntityGraph(attributePaths = {"schedule", "schedule.bus"})
	List<Booking> findByUserEmail(String email);

	
}
