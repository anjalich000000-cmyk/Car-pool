import java.util.ArrayList;
import java.util.List;
public class RideBookingSystem {
    //user
    userList
    signup(){

    }
    login(){

    }
    updateUserDetails(){

    }
    deleteAccount(){

    }
    //future Scope
    //time
    //authentication
    //admin
    //mul tilocation
    //price gbargain
    //ai chatbot
    //review
    //chat
    public List<Ride>  rideList = new ArrayList<>();
    public void createRide(int id, String Source, String destination,int seats,double fare,user User){
        Ride ride = new Ride( id,Source, destination, seats, fare,User);
        rideList.add(ride);
    }

    public List<Ride> showAllRide() {
        return rideList;
    }
    public List<Ride> bookRide(String Source, String destination,int seats){
        List<Ride> availableRide = new ArrayList<>();
        for(Ride ride: rideList){
            if (ride.source.equals(Source) && ride.destination.equals(destination)&&ride.seats>=(seats)){
                availableRide.add(ride);
            }
        }
        return availableRide;
    }
    updateRide(){

    }
    deleteRide(){

    }
    bookingList
    public void bookRide(Ride ride,user User,int seats_booked){
        //search ride
        //available seats>= requied seat
        //fare calculate
        //boooking create
        //ride -> available seeat-> availble seat - seats_booked

    }
    viewRideCreated(){
        //ridelist -> filter -useridl

    }
    udateBooking(){
        //bookinglist -> filter - userid;

    }
    deleteBooking(){}

}