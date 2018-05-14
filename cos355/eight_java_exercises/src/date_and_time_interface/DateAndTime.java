package date_and_time_interface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface DateAndTime {
    LocalDate currentDate();

    LocalTime currentTime();

    LocalDateTime currentDateTime();

    int year();

    int month();

    int day();

    int hour();

    int minute();

    int second();
}
