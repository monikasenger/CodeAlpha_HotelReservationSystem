package HotelReservationSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelReservationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	      HotelReservation res=new HotelReservation();
	        while (true) {
				System.out.println("\t******************** HOTEL RESERVATION SYSTEM ********************");
				
	            System.out.println("[1] Search Available Rooms\n[2] Make Reservation\n[3] View Booking Details\n[4] Process Payment\n[5] Exit");
	            
	            System.out.println("\nChoose an option: ");
	            int option = sc.nextInt();
	            sc.nextLine();
	            
	            System.out.println("\n");

	            switch (option) {
	                case 1:
						res.searchroom(); //search room method
	                    System.out.println("\n");
	                    break;
	                case 2:
						res.makereservation();// make reservation method
	                    System.out.println("\n");
	                    break;
	                case 3:
					res.viewbooking();// view booking method
	                    System.out.println("\n");
	                    break;
	                case 4:					
	                    res.payment();// payment mathod
	                    System.out.println("\n");
	                    break;
	                case 5:
	                   res.exit();// exit method
	                    return;
	                default:
	                    System.out.println("\tInvalid option! Please try again.");
	            }
	        }
	    }
	}