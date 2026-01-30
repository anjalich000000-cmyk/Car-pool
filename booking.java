public class Booking {
    int booking_id;
    Ride ride;
    user User;
    int seats_book;
    double total_fare;

    public Booking(Ride ride, int booking_id, user user, int seats_book, double total_fare) {
        this.ride = ride;
        this.booking_id = booking_id;
        User = user;
        this.seats_book = seats_book;
        this.total_fare = total_fare;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", ride=" + ride +
                ", User=" + User +
                ", seats_book=" + seats_book +
                ", total_fare=" + total_fare +
                '}';
    }
}