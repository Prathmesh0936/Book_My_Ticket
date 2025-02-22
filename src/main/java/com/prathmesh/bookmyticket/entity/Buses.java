package com.prathmesh.bookmyticket.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Buses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//Name of the bus
	private String name;
	
	//Starting route of bus
	private String source;
	
	//destination of the bus
	private String destination;
	
	//total seats in the bus
	private Integer total_seats;
	
	//The company which operators bus service
	private String operator;
	
	// amenities like AC / Non-Ac bus
	private String amenities;
	
	// Total time taken to Complete the journey.
	private String journey_duration;

	@OneToMany(mappedBy = "bus")
	private List<Schedule> schedules;
	
	@OneToMany(mappedBy = "bus")
	private List<PDFGeneration> pdfGenerations;
	
	@CreatedDate
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime updated_at;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	@Override
	public String toString() {
		return "Buses [id=" + id + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", total_seats=" + total_seats + ", operator=" + operator + ", amenities=" + amenities
				+ ", journey_duration=" + journey_duration + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}
	
}
