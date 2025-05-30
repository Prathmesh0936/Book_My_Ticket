package com.prathmesh.bookmyticket.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prathmesh.bookmyticket.entity.PDFGeneration;

@Repository
public interface PDFGeneration_Repository extends JpaRepository<PDFGeneration, Integer> {

	// Find all PDFs generated for a specific user
    List<PDFGeneration> findByUserId(Integer userId);

    // Find all PDFs generated for a specific bus
    List<PDFGeneration> findByBusId(Integer busId);

    // Find all PDFs generated for a specific schedule
    List<PDFGeneration> findByScheduleId(Integer scheduleId);
//
//    // Find all PDFs for a specific booking
//    PDFGeneration findByBookingId(Integer bookingId);
	
    Optional<PDFGeneration> findByBookingId(Integer bookingId);
}
