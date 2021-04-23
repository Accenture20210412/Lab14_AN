package com.accenture.traveloffice.models;

import com.accenture.traveloffice.repositories.CustomerRepository;
import com.accenture.traveloffice.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TravelOffice {
    private final CustomerRepository customers;
    private final TripRepository trips;

    @Autowired
    public TravelOffice(CustomerRepository customers, TripRepository trips) {
        this.customers = customers;
        this.trips = trips;
    }

    public boolean addCustomer(Customer customer) {
        return customers.add(customer);
    }

    public boolean removeCustomer(Customer customer) {
        return customers.remove(customer);
    }

    public boolean removeCustomerByFirstName(String firstName) {
        return customers.removeByFirstName(firstName);
    }

    public boolean removeCustomerByLastName(String lastName) {
        return customers.removeByLastName(lastName);
    }

    public void assignTripToCustomer(Customer customer, Trip trip) {
        customers.assignTrip(customer, trip);
    }

    public boolean addTrip(Trip trip) {
        return trips.add(trip);
    }

    public boolean removeTrip(Trip trip) {
        return trips.remove(trip);
    }

    public void removeTripByName(String name) {
        trips.removeByName(name);
    }

    public Trip getTripByName(String name) {
        return trips.getByName(name);
    }

    public List<Trip> getTripByDestination(String destination) {
        return trips.getByDestination(destination);
    }

    public List<Trip> getTripsAfterDate(Date date) {
        return trips.getAfterDate(date);
    }

    public String getCustomersInfo() {
        List<Customer> listOfCustomers = customers.getAll();

        StringBuilder sb = new StringBuilder();

        sb.append("TravelOffice Customers {\n");

        for (int i = 0; i < listOfCustomers.size(); i++) {
            sb.append(String.format("\t[%d] %s\n", i, listOfCustomers.get(i)));
        }

        sb.append("}");

        return sb.toString();
    }

    public List<Trip> getAllTrips() {
        return trips.getAll();
    }

    public String getTripsInfo() {
        List<Trip> listOfTrips = trips.getAll();

        StringBuilder sb = new StringBuilder();

        sb.append("TravelOffice Trips {\n");

        for (int i = 0; i < listOfTrips.size(); i++) {
            sb.append(String.format("\t[%d] %s\n", i, listOfTrips.get(i)));
        }

        sb.append("}");

        return sb.toString();
    }

    public int getTripAmount() {
        return trips.getTripAmounts();
    }

    public int getCustomerAmount() {
        return customers.getCustomerAmounts();
    }
}
