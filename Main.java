

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        RideBookingSystem rideBookingSystem = new RideBookingSystem();


        rideBookingSystem .createRide(2,"jaipur","madhubani",2,232.00);
        rideBookingSystem .createRide(3,"agar","new delhi",5,232.00);

//      System.out.println(rideBookingSystem.showAllRide());

        List<Ride> result = rideBookingSystem.bookRide("agar","new delhi",5);

        System.out.println(result);
    }

}