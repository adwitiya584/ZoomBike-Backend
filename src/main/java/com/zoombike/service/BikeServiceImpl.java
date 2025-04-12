package com.zoombike.service;

import com.zoombike.model.Bike;
import com.zoombike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public Bike saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public Bike getBikeById(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }
    @Override
    public List<Bike> filterByLocation(String location) {
        return bikeRepository.findByLocationContainingIgnoreCase(location);
    }

    @Override
    public List<Bike> filterByAvailability(boolean available) {
        return bikeRepository.findByAvailable(available);
    }
    
}