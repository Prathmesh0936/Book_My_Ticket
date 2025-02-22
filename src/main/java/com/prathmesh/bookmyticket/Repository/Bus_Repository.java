package com.prathmesh.bookmyticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.Buses;

@Repository
public interface Bus_Repository extends JpaRepository<Buses, Integer> {

}
