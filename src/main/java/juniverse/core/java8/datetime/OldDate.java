package juniverse.core.java8.datetime;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tunm2
 */
public class OldDate {
    
    public static void main(String[] args) {
        Date now = new Date(System.currentTimeMillis());
        System.err.println(now);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 11, 1);
        Date date = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        System.err.println(date);
        
    }
    
}
