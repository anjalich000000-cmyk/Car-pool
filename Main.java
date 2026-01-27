import java.util.ArrayList;
import java.util.List;

public class Main{
   public  static void main(String[] args) {
       RideBookingSystem rideBookingSystem = new RideBookingSystem();
       rideBookingSystem.createRide(id:1,source:"Jaipur", destination:"delhi",seats: 5, fare:725.00);
       rideBookingSystem.createRide(id:2,source:"gurugram", destination:"fariadbad",seats: 3, fare:225.00);
       rideBookingSystem.createRide(id:3, source:"greater noida", destination:"agra",seats: 2, fare:170.00);
       System.out.println(rideBookingSystem.showAllRide());


    }
}