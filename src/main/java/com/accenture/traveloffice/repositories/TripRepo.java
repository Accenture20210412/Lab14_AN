package com.accenture.traveloffice.repositories;

import com.accenture.traveloffice.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface TripRepo extends JpaRepository<Trip, Long> {

    Optional<List<Trip>> findAllByDestination(String destination);
    void deleteByName(String name);


}
