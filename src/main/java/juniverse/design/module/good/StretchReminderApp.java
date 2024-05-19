package juniverse.design.module.good;

/**
 * Now, the App only depends on ReminderTask, and doesn't depend on ReminderTimer anymore
 * 
 * @author tunm2
 */
public class StretchReminderApp {

    ReminderTask task;

    public static void main(String[] args) {
        ReminderTask task = new ReminderTask();
        StretchReminderApp app = new StretchReminderApp(task);
        app.run();
    }
    
    public StretchReminderApp(ReminderTask task) {
        this.task = task;
    }
    
    public void run() {
        task.start();
    }
    
}