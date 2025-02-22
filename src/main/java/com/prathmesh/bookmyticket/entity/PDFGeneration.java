package com.prathmesh.bookmyticket.entity;

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
public class PDFGeneration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String pdfFileName;
	private String pdfStatus;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	@RestResource(path = "pdfBooking", rel = "booking")
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@RestResource(path = "pdfUser", rel = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	@RestResource(path = "pdfSchedule", rel = "schedule")
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	@RestResource(path = "pdfBus", rel = "bus")
	private Buses bus; 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPdfFileName() {
		return pdfFileName;
	}
	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}
	public String getPdfStatus() {
		return pdfStatus;
	}
	public void setPdfStatus(String pdfStatus) {
		this.pdfStatus = pdfStatus;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Buses getBus() {
		return bus;
	}
	public void setBus(Buses bus) {
		this.bus = bus;
	}
	@Override
	public String toString() {
		return "PDFGeneration [id=" + id + ", pdfFileName=" + pdfFileName + ", pdfStatus=" + pdfStatus + "]";
	}
	
}
