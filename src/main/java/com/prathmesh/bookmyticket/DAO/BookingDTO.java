package com.prathmesh.bookmyticket.DAO;


import com.prathmesh.bookmyticket.entity.Booking;
import com.prathmesh.bookmyticket.entity.Schedule;

public class BookingDTO {
    private Integer id;
    private String status;
    private String selectedSeats;
    private Double totalAmount;

    private String busName;
    private String source;
    private String destination;

    private String date;
    private String time;

    private String pdfStatus;

    // Constructor to map from Booking entity
    public BookingDTO(Booking booking) {
        this.id = booking.getId();
        this.status = booking.getStatus();
        this.selectedSeats = booking.getSelectedSeats();
        this.totalAmount = booking.getTotal_amount();

        Schedule schedule = booking.getSchedule();
        if (schedule != null) {
            this.date = schedule.getDate();
            this.time = schedule.getTime();
            if (schedule.getBus() != null) {
                this.busName = schedule.getBus().getName();
                this.source = schedule.getBus().getSource();
                this.destination = schedule.getBus().getDestination();
            }
        }

        this.pdfStatus = booking.getPdfGeneration() != null 
            ? booking.getPdfGeneration().getPdfStatus() 
            : "PENDING";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(String selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPdfStatus() {
		return pdfStatus;
	}

	public void setPdfStatus(String pdfStatus) {
		this.pdfStatus = pdfStatus;
	}

 
}

