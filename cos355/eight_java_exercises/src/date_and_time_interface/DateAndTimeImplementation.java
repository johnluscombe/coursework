package date_and_time_interface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateAndTimeImplementation implements DateAndTime {
    public LocalDate currentDate() {
        return LocalDate.now();
    }

    public LocalTime currentTime() {
        return LocalTime.now().withNano(0);
    }

    public LocalDateTime currentDateTime() {
        return LocalDateTime.now().withNano(0);
    }

    public int year() {
        return LocalDate.now().getYear();
    }

    public int month() {
        return LocalDate.now().getMonthValue();
    }

    public int day() {
        return LocalDate.now().getDayOfMonth();
    }

    public int hour() {
        return LocalTime.now().getHour();
    }

    public int minute() {
        return LocalTime.now().getMinute();
    }

    public int second() {
        return LocalTime.now().getSecond();
    }

    public static void main(String[] args) {
        DateAndTimeImplementation dti = new DateAndTimeImplementation();
        System.out.println(dti.currentDate());
        System.out.println(dti.currentTime());
        System.out.println(dti.currentDateTime());
        System.out.println(dti.year());
        System.out.println(dti.month());
        System.out.println(dti.day());
        System.out.println(dti.hour());
        System.out.println(dti.minute());
        System.out.println(dti.second());
    }
}
