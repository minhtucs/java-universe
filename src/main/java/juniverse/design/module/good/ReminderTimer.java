package juniverse.design.module.good;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author tunm2
 */
public class ReminderTimer {
    
    final Timer timer = new Timer(); // system dependency, no needs to inject
    final int intervalMillis = 2000;

    TimerTask task;

    public ReminderTimer(TimerTask task) {
        this.task = task;
    }

    void start() {
        timer.schedule(task, 0, intervalMillis);
    }
    
}
