package juniverse.core.java8.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 *
 * @author tunm2
 */
public class WeekYearDays {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2021, Month.JANUARY, 1);
        System.err.println(date1.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        
        LocalDate date2 = LocalDate.of(2021, Month.DECEMBER, 30);
        System.err.println(date2.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        
    }
    
}
