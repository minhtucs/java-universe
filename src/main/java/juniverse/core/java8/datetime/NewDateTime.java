package juniverse.core.java8.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tunm2
 */
public class NewDateTime {
    
    static Timer timer = new Timer();
    
    public static void main(String[] args) {
        atStartOfNextMonth();
    }
    
    static void truncateTime() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.err.println("EXECUTED AT " + LocalDateTime.now());
            }
        };
        
//        LocalDateTime midNight = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.DAYS).plusHours(1);
        LocalDateTime midNight = LocalDateTime.now().plusMinutes(1).truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime now = LocalDateTime.now();
        
        Duration duration = Duration.between(now, midNight);
        System.err.println(duration.toMillis());
        
        timer.scheduleAtFixedRate(task, duration.toMillis(), TimeUnit.MINUTES.toMillis(1));
    }
    
    static void atStartOfNextMonth() {
        LocalDateTime atStartOfMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay();
        System.err.println(atStartOfMonth);
    }
    
}
