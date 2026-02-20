package com.carpool.model;

public class Booking {
    private int id;
    private Ride ride;
    private User user;
    private int seatsBooked;
    private double totalFare;

    public Booking(int id, Ride ride, User user, int seatsBooked) {
        this.id = id;
        this.ride = ride;
        this.user = user;
        this.seatsBooked = seatsBooked;
        this.totalFare = seatsBooked * ride.getFarePerSeat();
    }

    @Override
    public String toString() {
        return "Booking{id=" + id +
                ", user=" + user.getName() +
                ", ride=" + ride +
                ", seatsBooked=" + seatsBooked +
                ", totalFare=" + totalFare + '}';
    }
}