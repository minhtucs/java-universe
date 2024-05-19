import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author tunm2
 */
public class TypingBreakReminderApp {

    int intervalMillis;
    Timer timer;
    TimerTask reminder;

    private TypingBreakReminderApp(int intervalMillis, Timer timer, TimerTask reminder) {
        this.intervalMillis = intervalMillis;
        this.timer = timer;
        this.reminder = reminder;
    }
    
    public void run() {
        timer.schedule(reminder, 0, intervalMillis);
    }
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimeToStretch reminer = new TimeToStretch();
        TypingBreakReminderApp app = new TypingBreakReminderApp(2000, timer, reminer);
        app.run();
    }
    
}