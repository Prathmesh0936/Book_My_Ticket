package com.prathmesh.bookmyticket.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.rest.core.annotation.RestResource;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	private String date;
	private String time;
	private String available_seats;
	private Float fare;
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	@RestResource(path =  "busSchedule" , rel = "bus")
	private Buses bus;
	
	@OneToMany(mappedBy = "schedule")
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "schedule")
	private List<PDFGeneration> pdfGenerations;
	
	@CreatedDate
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime updated_at;
	
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
	public String getAvailable_seats() {
		return available_seats;
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
	public void setAvailable_seats(String available_seats) {
		this.available_seats = available_seats;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", time=" + time + ", available_seats=" + available_seats
				+ ", fare=" + fare + ", pdfGenerations=" + pdfGenerations + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}

	
}
