package com.prathmesh.bookmyticket.Service;

import com.prathmesh.bookmyticket.DAO.BookingDTO;
import com.prathmesh.bookmyticket.DAO.BookingRequest;
import com.prathmesh.bookmyticket.Repository.Booking_Repository;
import com.prathmesh.bookmyticket.Repository.PDFGeneration_Repository;
import com.prathmesh.bookmyticket.Repository.Schedule_Repository;
import com.prathmesh.bookmyticket.Repository.User_Repository;
import com.prathmesh.bookmyticket.entity.Booking;
import com.prathmesh.bookmyticket.entity.PDFGeneration;
import com.prathmesh.bookmyticket.entity.Schedule;
import com.prathmesh.bookmyticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private Booking_Repository bookingRepository;

    @Autowired
    private Schedule_Repository scheduleRepository;

    @Autowired
    private User_Repository userRepository;

    @Autowired
    private PDFGeneration_Repository pdfGenerationRepository; // Injected for PDF record creation

    // Create a new booking from BookingRequest DTO
    public Booking createBookingFromRequest(BookingRequest bookingRequest) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(bookingRequest.getScheduleId());
        if (scheduleOptional.isEmpty()) {
            throw new IllegalArgumentException("Schedule not found with id: " + bookingRequest.getScheduleId());
        }

        Optional<User> userOptional = userRepository.findByEmail(bookingRequest.getUserEmail());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found with email: " + bookingRequest.getUserEmail());
        }

        Schedule schedule = scheduleOptional.get();
        User user = userOptional.get();

        String selectedSeats = bookingRequest.getSelectedSeats();
        int seatCount = (selectedSeats != null && !selectedSeats.isBlank())
                ? selectedSeats.split(",").length
                : 0;

        double farePerSeat = schedule.getFare();
        double totalAmount = seatCount * farePerSeat;

        Booking booking = new Booking();
        booking.setSelectedSeats(selectedSeats);
        booking.setStatus(bookingRequest.getStatus());
        booking.setTotal_amount(totalAmount);
        booking.setSchedule(schedule);
        booking.setUser(user);

        Booking savedBooking = bookingRepository.save(booking);


        PDFGeneration pdf = new PDFGeneration();
        pdf.setBooking(savedBooking);
        pdf.setUser(user);
        pdf.setSchedule(schedule);
        pdf.setBus(schedule.getBus());
        pdf.setPdfFileName("ticket_" + savedBooking.getId() + ".pdf");
        pdf.setPdfStatus("PENDING");

        pdfGenerationRepository.save(pdf);

        return savedBooking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    public Booking updateBooking(Integer id, Booking updatedBooking) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setSelectedSeats(updatedBooking.getSelectedSeats());
                    booking.setStatus(updatedBooking.getStatus());
                    booking.setTotal_amount(updatedBooking.getTotal_amount() != null ? updatedBooking.getTotal_amount() : 0.0);
                    return bookingRepository.save(booking);
                })
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    
    public List<BookingDTO> getBookingsByUserEmail(String email) {
        List<Booking> bookings = bookingRepository.findByUserEmail(email);
        return bookings.stream().map(BookingDTO::new).collect(Collectors.toList());
    }


}
