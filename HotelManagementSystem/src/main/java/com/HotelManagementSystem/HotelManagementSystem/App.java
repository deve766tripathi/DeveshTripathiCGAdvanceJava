package com.HotelManagementSystem.HotelManagementSystem;

/**
 * Hello world!
 *
 */
import java.util.List;
public class App 
{
	public static void main(String[] args) {

        BookingDAO dao = new BookingDAO();

        Booking b1 = new Booking(
                "Devesh",
                "Deluxe",
                "2026-02-14",
                "2026-02-17"
        );

        dao.addBooking(b1);

        System.out.println("All Bookings:");
        List<Booking> bookings = dao.viewAllBookings();

        for (Booking b : bookings) {
            System.out.println(
                    b.getBookingId() + " " +
                    b.getCustomerName() + " " +
                    b.getRoomType() + " " +
                    b.getTotalAmount()
            );
        }

        dao.updateBooking(1, "Suite");
        dao.deleteBooking(1);
    }
}
