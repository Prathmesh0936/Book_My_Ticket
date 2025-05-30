package com.prathmesh.bookmyticket.DAO;

public class ScheduleDTO {
	    private Integer id;
	    private String date;
	    private String time;
	    private Float fare;
	    private String availableSeats;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
		public Float getFare() {
			return fare;
		}
		public void setFare(Float fare) {
			this.fare = fare;
		}
		public String getAvailableSeats() {
			return availableSeats;
		}
		public void setAvailableSeats(String availableSeats) {
			this.availableSeats = availableSeats;
		}

	    
}
