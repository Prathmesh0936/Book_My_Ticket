package com.prathmesh.bookmyticket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.Buses;

@Repository
public interface Bus_Repository extends JpaRepository<Buses, Integer> {
	
	// Custom query method to find buses by source and destination
    List<Buses> findBySourceAndDestination(String source, String destination);

}
