package com.prathmesh.bookmyticket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.Schedule;

@Repository
public interface Schedule_Repository extends JpaRepository<Schedule, Integer> {

	 List<Schedule> findByBusId(Integer busId);
	 
}
