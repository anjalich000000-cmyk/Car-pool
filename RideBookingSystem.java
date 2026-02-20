package com.carpool.service;

import com.carpool.db.DBConnection;
import com.carpool.model.Ride;
import com.carpool.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    // STEP 5: Signup (Insert User)
    public void signup(User user) {
        String sql = "INSERT INTO users (id, name, email, password) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();
            System.out.println(" User registered!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // STEP 5: Create Ride
    public void createRide(int id, String source, String destination, int seats, double fare, User user) {

        String sql = "INSERT INTO rides (id, source, destination, available_seats, fare_per_seat, owner_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, source);
            ps.setString(3, destination);
            ps.setInt(4, seats);
            ps.setDouble(5, fare);
            ps.setInt(6, user.getId());

            ps.executeUpdate();
            System.out.println(" Ride created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // STEP 6: Search Ride
    public List<Ride> searchRide(String source, String destination, int seats) {

        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM rides WHERE source=? AND destination=? AND available_seats >= ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, source);
            ps.setString(2, destination);
            ps.setInt(3, seats);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ride ride = new Ride(
                        rs.getInt("id"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getInt("available_seats"),
                        rs.getDouble("fare_per_seat"),
                        null
                );
                rides.add(ride);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rides;
    }

    // STEP 7: Book Ride (Transaction)
    public void bookRide(int rideId, int userId, int seats) {

        String checkSql = "SELECT available_seats, fare_per_seat FROM rides WHERE id=?";
        String updateSql = "UPDATE rides SET available_seats = available_seats - ? WHERE id=?";
        String insertSql = "INSERT INTO bookings (user_id, ride_id, seats_booked, total_fare) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement check = con.prepareStatement(checkSql);
            check.setInt(1, rideId);
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println(" Ride not found!");
                return;
            }

            int available = rs.getInt("available_seats");
            double fare = rs.getDouble("fare_per_seat");

            if (available < seats) {
                System.out.println("Not enough seats!");
                return;
            }

            PreparedStatement update = con.prepareStatement(updateSql);
            update.setInt(1, seats);
            update.setInt(2, rideId);
            update.executeUpdate();

            PreparedStatement insert = con.prepareStatement(insertSql);
            insert.setInt(1, userId);
            insert.setInt(2, rideId);
            insert.setInt(3, seats);
            insert.setDouble(4, seats * fare);
            insert.executeUpdate();

            con.commit();
            System.out.println(" Booking successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}