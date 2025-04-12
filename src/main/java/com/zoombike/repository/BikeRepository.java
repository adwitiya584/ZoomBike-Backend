package com.zoombike.repository;

import com.zoombike.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
    List<Bike> findByLocationContainingIgnoreCase(String location);
    List<Bike> findByAvailable(boolean available);
}

