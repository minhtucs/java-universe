package juniverse.design.module.bad;

/**
 * In this version, the App depends both on:
 *     + ReminderTimer: declared as a field
 *     + ReminderTask: called in the initialization code
 * So, is depending on ReminderTimer needed? How to eleminate this?
 *
 * @author tunm2
 */
public class StretchReminderApp {

    ReminderTimer timer;
    
    public static void main(String[] args) {
        ReminderTask task = new ReminderTask();
        ReminderTimer timer = new ReminderTimer(task);
        
        StretchReminderApp app = new StretchReminderApp(timer);
        app.run();
    }

    private StretchReminderApp(ReminderTimer timer) {
        this.timer = timer;
    }
    
    public void run() {
        timer.start();
    }   
}