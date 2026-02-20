package com.carpool.model;

public class Ride {
    private int id;
    private String source;
    private String destination;
    private int availableSeats;
    private double farePerSeat;
    private User owner;

    public Ride(int id, String source, String destination, int availableSeats, double farePerSeat, User owner) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.farePerSeat = farePerSeat;
        this.owner = owner;
    }

    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getFarePerSeat() { return farePerSeat; }

    public void reduceSeats(int seats) {
        this.availableSeats -= seats;
    }

    @Override
    public String toString() {
        return "Ride{id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + availableSeats +
                ", fare=" + farePerSeat + '}';
    }
}