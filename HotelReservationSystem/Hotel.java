package HotelReservationSystem;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
	 private List<Room> rooms;
	    private List<Booking> bookings;
	    private Map<String, Double> paymentMethods;
	    private int nextBookingId;

	    // hotel class constructor
	    public Hotel() {
	        rooms = new ArrayList<>();
	        bookings = new ArrayList<>();
	        paymentMethods = new HashMap<>();
	        nextBookingId = 1;

	        rooms.add(new Room(101, "Single", 100.0));
	        rooms.add(new Room(102, "Double", 150.0));
	        rooms.add(new Room(103, "Suite", 250.0));

	        paymentMethods.put("Cash", 0.0);
	        paymentMethods.put("Credit Card", 2.5);
	        paymentMethods.put("Debit Card", 1.5);
	    }

	    // search room method
	    
	    public void searchRooms(String category) {
	        System.out.println("\nAvailable rooms in " + category + " category: ");
	        for (Room room : rooms) {
	            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
	                System.out.println( room);
	            }
	        }
	    }

	    //make reservation method
	    public boolean makeReservation(int roomNumber, String guestName, long contactno, LocalDate checkInDate, LocalDate checkOutDate) {
	        for (Room room : rooms) {
	            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
	                Booking booking = new Booking(nextBookingId++, room, guestName,contactno, checkInDate, checkOutDate);
	                bookings.add(booking);
	                room.setAvailable(false);
	                System.out.println("\nReservation made successfully! Booking ID: " + booking.getBookingId());
	                return true;
	            }
	        }
	        System.out.println("\nRoom not available or not found!");
	        return false;
	    }

	    // view booking detail method
	    public void viewBookingDetails(int bookingId) {
	        for (Booking booking : bookings) {
	            if (booking.getBookingId() == bookingId) {
	                System.out.println(booking);
	                return;
	            }
	        }
	        System.out.println("\nBooking not found!");
	    }

	    //payment processing method
	    public void processPayment(int bookingId, String paymentMethod) {
	        Booking booking = findBookingById(bookingId);
	        if (booking != null) {
	            double totalCost = booking.getTotalCost();
	            Double fee = paymentMethods.get(paymentMethod);
	            if (fee != null) {
	                System.out.println("\nPayment processed successfully! Total amount paid: $" + (totalCost + fee));
	            } else {
	                System.out.println("\nInvalid payment method!");
	            }
	        } else {
	            System.out.println("\nBooking not found!");
	        }
	    }

	    //find booking id method
	    private Booking findBookingById(int bookingId) {
	        for (Booking booking : bookings) {
	            if (booking.getBookingId() == bookingId) {
	                return booking;
	            }
	        }
	        return null;
	    }
	}