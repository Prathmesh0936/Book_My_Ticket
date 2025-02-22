package com.prathmesh.bookmyticket.DAO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Add_Bus_DAO {
	
	@NotBlank(message = "Bus Must have a Name")
	private String name;
	
	@NotBlank(message = "Bus Route is required")
	private String source;
	
	@NotBlank(message = "Bus last Destination is required")
	private String destination;
	
	@NotNull(message = "Number of total seats in the bus is required")
	private Integer total_seats;
	
	@NotBlank(message = "Name of the Bus operator Company is required")
	private String operator;
	
	@NotBlank(message =  "Amenities are required")
	private String amenities;
	
	private String journey_duration;

	public String getJourney_duration() {
		return journey_duration;
	}

	public void setJourney_duration(String journey_duration) {
		this.journey_duration = journey_duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(Integer total_seats) {
		this.total_seats = total_seats;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	@Override
	public String toString() {
		return "Add_Bus_DAO [name=" + name + ", source=" + source + ", destination=" + destination + ", total_seats="
				+ total_seats + ", operator=" + operator + ", amenities=" + amenities + ", journey_duration="
				+ journey_duration + "]";
	}
	
	

}
