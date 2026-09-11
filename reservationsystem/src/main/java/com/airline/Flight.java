package com.airline;
public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int totalSeats;
    private int availableSeats;
    private double price;

    public Flight(String flightNumber,String origin,String destination,String departureTime,int totalSeats,double price){
        this.flightNumber=flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.price = price; 
    }  
    public String getFlightNumber(){
        return flightNumber;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public String getDepartureTime(){
        return departureTime;
    }
    public int getTotalSeats(){
        return totalSeats;
    }
    public int getAvailableSeats(){
        return availableSeats;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public boolean bookSeat() throws SeatNotAvailableException {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            throw new SeatNotAvailableException("No seats available on flight " + flightNumber);
        }
    }
    public String toString(){
        return flightNumber + "|" + origin + "to" + destination + "|" + departureTime + "|Seats:" + availableSeats + "/" + totalSeats + "|Price:" + price;
    }
}
