package com.zoombike.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bikeId;
    private String userEmail;
    private LocalDate bookingDate;

    public Booking() {}

    public Booking(Long bikeId, String userEmail, LocalDate bookingDate) {
        this.bikeId = bikeId;
        this.userEmail = userEmail;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getBikeId() { return bikeId; }
    public void setBikeId(Long bikeId) { this.bikeId = bikeId; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
}
