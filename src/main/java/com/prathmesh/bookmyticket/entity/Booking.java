package com.prathmesh.bookmyticket.entity;

import java.time.LocalDateTime;

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
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String selectedSeats;
	private String status;
	private Float total_amount;
	
	@CreatedDate
	private LocalDateTime created_at;
	
	@LastModifiedDate
	private LocalDateTime updated_at;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@RestResource(path = "bookingUser", rel = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	@RestResource(path = "bookingSchedule", rel = "schedule")
	private Schedule schedule;
	
	@OneToOne(mappedBy = "booking")
	private PDFGeneration pdfGeneration;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Float getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Float total_amount) {
		this.total_amount = total_amount;
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
		return "Booking [id=" + id + ", selectedSeats=" + selectedSeats + ", status=" + status + ", total_amount="
				+ total_amount + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	

}
