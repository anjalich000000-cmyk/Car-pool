package com.carpool;

import com.carpool.model.User;
import com.carpool.service.RideBookingSystem;

public class Main {
    public static void main(String[] args) {

        RideBookingSystem system = new RideBookingSystem();

        User u1 = new User(1, "Aman", "aman@gmail.com", "1234");
        system.signup(u1);

        system.createRide(1, "Jaipur", "Delhi", 3, 500, u1);

        system.searchRide("Jaipur", "Delhi", 1)
                .forEach(System.out::println);

        system.bookRide(1, 1, 1);
    }
}