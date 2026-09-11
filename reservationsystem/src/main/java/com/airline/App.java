package com.airline;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner sc = new Scanner(System.in);

        system.addFlight(new Flight("AI101", "Delhi", "Mumbai", "10:00 AM", 2, 5000.0));
        system.addFlight(new Flight("AI202", "Mumbai", "Bangalore", "2:00 PM", 3, 3500.0));

        int choice = 0;
        int bookingCounter = 1;

        while (choice != 5) {
            System.out.println("\n----- Airline Reservation System -----");
            System.out.println("1. View All Flights");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View All Bookings");
            System.out.println("4. Cancel a Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                system.showAllFlights();
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Enter contact number: ");
                String contact = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter flight number: ");
                String flightNumber = sc.nextLine();
                System.out.print("Enter seat number: ");
                int seatNumber = Integer.parseInt(sc.nextLine());

                Passenger passenger = new Passenger("P" + bookingCounter, name, contact, email);
                String bookingId = "B" + bookingCounter;
                system.createBooking(bookingId, passenger, flightNumber, seatNumber);
                bookingCounter++;
            } else if (choice == 3) {
                system.showAllBookings();
            } else if (choice == 4) {
                System.out.print("Enter booking ID to cancel: ");
                String bookingId = sc.nextLine();
                system.cancelBooking(bookingId);
            } else if (choice == 5) {
                System.out.println("Exiting. Thank you!");
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
        system.saveBookingsToFile("bookings.txt");
        sc.close();
    }
}