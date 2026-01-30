





public class Ride {

    int id;
    String source;
    String destination;
    int seats;
    double fare;
    user User;

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", fare=" + fare +
                '}';
    }

    public Ride(int id, String Source, String destination, int seats, double fare) {
        this.id= id;
        this.source = Source;
        this.destination = destination;
        this.seats = seats;
        this.fare = fare;

    }

}