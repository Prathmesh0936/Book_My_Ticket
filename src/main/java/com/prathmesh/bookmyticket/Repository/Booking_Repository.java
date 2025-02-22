package com.prathmesh.bookmyticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.Booking;

@Repository
public interface Booking_Repository extends JpaRepository<Booking, Integer>{

}
