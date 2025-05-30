package com.prathmesh.bookmyticket.Service;

import com.prathmesh.bookmyticket.Repository.Schedule_Repository;
import com.prathmesh.bookmyticket.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private Schedule_Repository scheduleRepository;

    // Get all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    
    public List<Schedule> getSchedulesByBusId(Integer busId) {
        return scheduleRepository.findByBusId(busId);
    }

    // Get schedule by ID
    public Optional<Schedule> getScheduleById(Integer id) {
        return scheduleRepository.findById(id);
    }

    // Create a new schedule
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Update a schedule
    public Schedule updateSchedule(Integer id, Schedule schedule) {
        if (scheduleRepository.existsById(id)) {
            schedule.setId(id);
            return scheduleRepository.save(schedule);
        }
        return null;  // Or throw an exception depending on your use case
    }

    // Delete a schedule by ID
    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }
}