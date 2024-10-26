package HotelReservationSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
	 private int bookingId;
	    private Room room;
	    private String guestName;
	    private long contactno;
	    private LocalDate checkInDate;
	    private LocalDate checkOutDate;
	    private double totalCost;

	    public Booking(int bookingId, Room room, String guestName,long contactno, LocalDate checkInDate, LocalDate checkOutDate) {
	        this.bookingId = bookingId;
	        this.room = room;
	        this.guestName = guestName;
	        this.contactno=contactno;
	        this.checkInDate = checkInDate;
	        this.checkOutDate = checkOutDate;
	        this.totalCost = room.getPrice() * getNumberOfNights();
	    }

	    public long getContactno() {
			return contactno;
		}
	    
		public int getBookingId() {
	        return bookingId;
	    }

	    public Room getRoom() {
	        return room;
	    }

	    public String getGuestName() {
	        return guestName;
	    }

	    public LocalDate getCheckInDate() {
	        return checkInDate;
	    }

	    public LocalDate getCheckOutDate() {
	        return checkOutDate;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }
	    
        

		private long getNumberOfNights() {
	        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
	    }

	    @Override
	    public String toString() {
	        return "\n\tBooking ID: " + bookingId + "\n" +
	               "\tRoom: " + room + "\n" +
	               "\tGuest Name: " + guestName + "\n" +
	               "\tContact Number: " + contactno + "\n" +
	               "\tCheck-in Date: " + checkInDate + "\n" +
	               "\tCheck-out Date: " + checkOutDate + "\n" +
	               "\tTotal Cost: $" + totalCost;
	    }
	
	}