package com.accenture.traveloffice.controllers;

import com.accenture.traveloffice.models.TravelOffice;
import com.accenture.traveloffice.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController("/trips")
public class TripController {

    TravelOffice travelOffice;

    @Autowired
    public TripController(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }

    @ResponseBody
    @GetMapping
    public List<Trip> getAllTrips() {
        return travelOffice.getAllTrips();
    }

    @GetMapping(value = "/{destination}", params = {"destination"})
    public List<Trip> getTripByDestination(@RequestParam ("destination") String destination) {
        List<Trip> tripByDestination = travelOffice.getTripByDestination(destination);
        return tripByDestination;
    }

    @ResponseBody
    @GetMapping(value = "/{name}", params = {"name"})
    Trip getTripById(@RequestParam("name") String name) {
        return travelOffice.getTripByName(name);
    }

    @PostMapping
    public List<Trip> addTrip(@RequestBody Trip trip) {
        travelOffice.addTrip(trip);
        return travelOffice.getAllTrips();
    }

    @PutMapping
    public List<Trip> editTrip(@RequestBody Trip trip) {
        trip.setPrice(trip.getPrice().add(BigDecimal.ONE));
        travelOffice.addTrip(trip);
        return travelOffice.getAllTrips();
    }

    @DeleteMapping("/{name}")
    public List<Trip>  deleteTrip(@PathVariable String name) {
        travelOffice.removeTripByName(name);
        return travelOffice.getAllTrips();
    }

}
