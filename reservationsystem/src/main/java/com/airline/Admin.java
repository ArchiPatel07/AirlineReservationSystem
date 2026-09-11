package com.airline;

public class Admin extends Person {
    private String adminId;

    public Admin(String adminId, String name, String contactNumber) {
        super(name, contactNumber);
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void addFlightToSystem(ReservationSystem system, Flight flight) {
        system.addFlight(flight);
    }

    public String toString() {
        return adminId + " | " + getName() + " | " + getContactNumber();
    }
}