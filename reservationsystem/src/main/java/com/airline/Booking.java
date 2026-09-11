package com.airline;

public class Booking {
    private String bookingId;
    private Passenger passenger;
    private Flight flight;
    private int seatNumber;
    private String bookingStatus;

    public Booking(String bookingId, Passenger passenger, Flight flight, int seatNumber) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.bookingStatus = "CONFIRMED";
    }

    public String getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void cancelBooking() {
        this.bookingStatus = "CANCELLED";
    }

    public String toString() {
        return "Booking ID: " + bookingId + " | Passenger: " + passenger.getName() + " | Flight: " + flight.getFlightNumber() + " | Seat: " + seatNumber + " | Status: " + bookingStatus;
    }
}