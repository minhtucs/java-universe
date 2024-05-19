package juniverse.core.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author tunm2
 */
public class AdjustTimes {

    public static void main(String[] args) {
        
    }
    
    static LocalDateTime nextSaturday() {
        return LocalDate.now()
            .with(TemporalAdjusters.next(DayOfWeek.SATURDAY))
            .atStartOfDay();
    }
    
}
