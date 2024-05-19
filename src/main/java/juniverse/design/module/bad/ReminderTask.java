package juniverse.design.module.bad;

import java.util.TimerTask;

/**
 *
 * @author tunm2
 */
public class ReminderTask extends TimerTask {

    @Override
    public void run() {
        System.err.println("Time to stretch, just relax!");
    }

}
