package HotelReservationSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class HotelReservation {
	Scanner sc = new Scanner(System.in);
    Hotel hotel = new Hotel();

    //search room method
    public void searchroom() {
		System.out.println("----------SEARCH AVAILABLE ROOMS----------");
		System.out.print("Enter room category (Single/Double/Suite): ");
        String category = sc.nextLine();
        
        hotel.searchRooms(category);
    }
    
    //make reservation method
    public void makereservation() {
		System.out.println("----------MAKE RESERVATION----------");
		 System.out.println("Enter room number to book: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter guest name: ");
        String guestName = sc.nextLine();
        
        System.out.println("Enter guest contact number: ");
       long contactno = sc.nextLong();
        
        System.out.println("Enter check-in date (YYYY-MM-DD): ");
        String checkInStr = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Enter check-out date (YYYY-MM-DD): ");
        String checkOutStr = sc.nextLine();
        
        try {
            LocalDate checkInDate = LocalDate.parse(checkInStr);
            LocalDate checkOutDate = LocalDate.parse(checkOutStr);
            hotel.makeReservation(roomNumber, guestName, contactno, checkInDate, checkOutDate);
        } catch (Exception e) {
            System.out.println("\n\tInvalid date format! Please use YYYY-MM-DD.");
        }
    }
    
    //view booking method
    public void viewbooking() {
				System.out.println("----------VIEW BOOKING DETAILS----------|");
				  System.out.println("Enter booking ID to view: ");
                int bookingId = sc.nextInt();
                sc.nextLine();
                
                hotel.viewBookingDetails(bookingId);
                
    }
    
    //payment method
    public void payment() {
                System.out.println("----------PROCESS PAYMENT----------");
				System.out.println("Enter booking ID to process payment: ");
                int  bookingId = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Enter payment method (Cash/Credit Card/Debit Card): ");
                String paymentMethod = sc.nextLine();
                hotel.processPayment(bookingId, paymentMethod);
    }
    
    //exit method
    public void exit() {
                System.out.println("Exiting...");
                sc.close();
                return;
    }
    
        }
 