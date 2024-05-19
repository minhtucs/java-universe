package juniverse.design.module.good;

import java.util.TimerTask;

/**
 *
 * @author tunm2
 */
public class ReminderTask extends TimerTask {

    ReminderTimer timer;

    public ReminderTask() {
        timer = new ReminderTimer(this);
    }

    @Override
    public void run() {
        System.err.println("Time to stretch, just relax!");
    }

    void start() {
        timer.start();
    }

}
