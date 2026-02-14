package com.HotelManagementSystem.HotelManagementSystem;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static int getDaysBetween(String checkIn, String checkOut) {
        LocalDate in = LocalDate.parse(checkIn);
        LocalDate out = LocalDate.parse(checkOut);
        return (int) ChronoUnit.DAYS.between(in, out);
    }
}
