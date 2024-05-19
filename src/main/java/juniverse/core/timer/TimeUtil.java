package juniverse.core.timer;

import java.util.Calendar;

/**
 *
 * @author tunm2
 */
public class TimeUtil {
    
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        System.out.println(getHour(currentTime) + ":" + getMinute(currentTime));
    }
    
    /** Day of month */
    public static int getDate(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        return cal.get(Calendar.DATE);
    }
    
    public static int getHour(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        return cal.get(Calendar.HOUR);
    }
    
    public static int getMinute(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        return cal.get(Calendar.MINUTE);
    }
    
    /** Day of week */
    public static int getDay(long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
}
