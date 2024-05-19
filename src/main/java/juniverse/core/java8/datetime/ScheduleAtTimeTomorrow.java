package juniverse.core.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tunm2
 */
public class ScheduleAtTimeTomorrow {
    
    static LocalTime RUN_AT_TIME = LocalTime.of(22, 23, 0);
    
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            System.err.println("++ RUN......, at: " + LocalDateTime.now());
        }, getDelayTime(), TimeUnit.MILLISECONDS);
    }

    static long getDelayTime() {
        LocalDateTime time = LocalDateTime.now()
            .withHour(RUN_AT_TIME.getHour())
            .withMinute(RUN_AT_TIME.getMinute())
            .withSecond(RUN_AT_TIME.getSecond());
        
        if (time.isBefore(LocalDateTime.now())) {
            time = time.plusDays(1);
        }
        
        return Instant.from(time.atZone(ZoneId.systemDefault())).toEpochMilli() - System.currentTimeMillis();
    }
    
}
