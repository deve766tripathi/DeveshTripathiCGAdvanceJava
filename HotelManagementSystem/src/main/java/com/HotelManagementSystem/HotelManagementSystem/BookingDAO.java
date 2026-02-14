package com.HotelManagementSystem.HotelManagementSystem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BookingDAO {

    public void addBooking(Booking booking) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(booking);

        tx.commit();
        session.close();
    }

    public List<Booking> viewAllBookings() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Booking> list =
                session.createQuery("from Booking", Booking.class).list();
        session.close();
        return list;
    }

    public void updateBooking(int id, String roomType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Booking booking = session.get(Booking.class, id);
        if (booking != null) {
            booking.setRoomType(roomType);
        }

        tx.commit();
        session.close();
    }

    public void deleteBooking(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Booking booking = session.get(Booking.class, id);
        if (booking != null) {
            session.remove(booking);
        }

        tx.commit();
        session.close();
    }
}
