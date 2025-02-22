package com.prathmesh.bookmyticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.Schedule;

@Repository
public interface Schedule_Repository extends JpaRepository<Schedule, Integer> {

}
