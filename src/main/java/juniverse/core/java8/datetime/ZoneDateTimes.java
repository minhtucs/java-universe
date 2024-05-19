package juniverse.core.java8.datetime;

import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 *
 * @author tunm2
 */
public class ZoneDateTimes {

    public static void main(String[] args) {
        
    }
    
    static void createZoneId(int offset) {
        System.err.println(ZoneId.systemDefault());
        ZoneId zid = ZoneId.ofOffset("", ZoneOffset.ofHours(offset));
        System.err.println(zid);
    }
    
    
}
