package com.prathmesh.bookmyticket.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingRequest {
    private String userEmail;
    private String selectedSeats;
    private String status;
    @JsonProperty("totalAmount")
    private Double total_amount;
    private Integer scheduleId;

    // getters and setters
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getSelectedSeats() {
        return selectedSeats;
    }
    public void setSelectedSeats(String selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public Integer getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
