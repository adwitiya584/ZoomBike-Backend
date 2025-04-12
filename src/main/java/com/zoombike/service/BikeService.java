package com.zoombike.service;

import com.zoombike.model.Bike;
import java.util.List;

public interface BikeService {
    Bike saveBike(Bike bike);
    List<Bike> getAllBikes();
    Bike getBikeById(Long id);
    List<Bike> filterByLocation(String location);
    List<Bike> filterByAvailability(boolean available);
}