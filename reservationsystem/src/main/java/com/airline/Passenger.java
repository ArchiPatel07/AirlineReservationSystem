package com.airline;

public class Passenger extends Person {
    private String passengerId;
    private String email;

    public Passenger(String passengerId, String name, String contactNumber, String email) {
        super(name, contactNumber);
        this.passengerId = passengerId;
        this.email = email;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return passengerId + " | " + getName() + " | " + getContactNumber() + " | " + email;
    }
}