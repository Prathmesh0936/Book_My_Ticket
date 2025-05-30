package com.prathmesh.bookmyticket.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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

    private String name;
    private String source;
    private String destination;
    private Integer total_seats;
    private String operator;
    private String amenities;
    private String journey_duration;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "bus")
    @JsonIgnore
    private List<PDFGeneration> pdfGenerations;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    // === Getters and Setters ===

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getJourney_duration() {
        return journey_duration;
    }

    public void setJourney_duration(String journey_duration) {
        this.journey_duration = journey_duration;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    // ✅ Important: This sets the back-reference properly
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
        if (schedules != null) {
            for (Schedule schedule : schedules) {
                schedule.setBus(this);
            }
        }
    }

    public List<PDFGeneration> getPdfGenerations() {
        return pdfGenerations;
    }

    public void setPdfGenerations(List<PDFGeneration> pdfGenerations) {
        this.pdfGenerations = pdfGenerations;
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
                + ", journey_duration=" + journey_duration + ", created_at=" + created_at + ", updated_at="
                + updated_at + "]";
    }
}
