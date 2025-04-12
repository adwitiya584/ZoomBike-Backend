package com.zoombike.controller;

import com.zoombike.model.Booking;
import com.zoombike.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping
    public Booking bookBike(@RequestBody Booking booking) {
        booking.setBookingDate(LocalDate.now());
        return bookingRepository.save(booking);
    }

    @GetMapping("/user/{email}")
    public List<Booking> getBookingsForUser(@PathVariable String email) {
        return bookingRepository.findByUserEmail(email);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
