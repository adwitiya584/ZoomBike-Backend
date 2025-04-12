package com.zoombike.controller;

import com.zoombike.model.Bike;
import com.zoombike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
@CrossOrigin(origins = "http://localhost:3000")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping
    public Bike addBike(
            @ModelAttribute Bike bike,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) {
        if (image != null) {
            System.out.println("Received image: " + image.getOriginalFilename());
            // Optional: Save image to DB or file system if needed
            // For now, you could also set bike.setImageName(image.getOriginalFilename()) if your model has such field
        }
        return bikeService.saveBike(bike);
    }

    @GetMapping
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("/{id}")
    public Bike getBike(@PathVariable Long id) {
        return bikeService.getBikeById(id);
    }

    @GetMapping("/filter/location")
    public List<Bike> filterByLocation(@RequestParam String location) {
        return bikeService.filterByLocation(location);
    }

    @GetMapping("/filter/available")
    public List<Bike> filterByAvailability(@RequestParam boolean available) {
        return bikeService.filterByAvailability(available);
    }
}
