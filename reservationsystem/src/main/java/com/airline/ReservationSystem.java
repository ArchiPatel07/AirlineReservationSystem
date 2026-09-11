package com.airline;
import java.util.ArrayList;
public class ReservationSystem {
    private ArrayList<Flight> flights;
    private ArrayList<Booking> bookings;
    
    public ReservationSystem(){
        this.flights = new ArrayList<Flight>();
        this.bookings = new ArrayList<Booking>();
    }
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight.getFlightNumber());
    }

    public Flight findFlightByNumber(String flightNumber) {
        for(int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            if (f.getFlightNumber().equals(flightNumber)) {
                return f;
            }
        }
        return null;
    }

    public void showAllFlights() {
        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }
    }

    public Booking createBooking(String bookingId, Passenger passenger, String flightNumber, int seatNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found: " + flightNumber);
            return null;
        }
        try {
            flight.bookSeat();
            Booking booking = new Booking(bookingId, passenger, flight, seatNumber);
            bookings.add(booking);
            System.out.println("Booking created: " + bookingId);
            return booking;
        } catch (SeatNotAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
            return null;
        }
    }
    public void cancelBooking(String bookingId) {
        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            if (b.getBookingId().equals(bookingId)) {
                b.cancelBooking();
                System.out.println("Booking cancelled: " + bookingId);
                return;
            }
        }
        System.out.println("Booking not found: " + bookingId);
    }
    public void showAllBookings() {
        for(int i = 0; i < bookings.size(); i++) {
            System.out.println(bookings.get(i));
        }
    }
    public void saveBookingsToFile(String filename) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(filename);
            for (int i = 0; i < bookings.size(); i++) {
                writer.write(bookings.get(i).toString() + "\n");
            }
            writer.close();
            System.out.println("Bookings saved to " + filename);
        } catch (java.io.IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
