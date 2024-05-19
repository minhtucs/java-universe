package juniverse.core.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tunm2
 */
public class ConvertAndFormat {

    static DateTimeFormatter TIME_FORMATRER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.err.println(time);
        
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.err.println(defaultZoneId);
    }

    // "2021-02-16 10:30:00"
    static LocalDateTime fromText(String text) {
        return LocalDateTime.parse(text, TIME_FORMATRER);
    }
    
    static String toText(LocalDateTime dt) {
        return TIME_FORMATRER.format(dt);
    }
    
    static LocalDateTime milliseconds_to_LocalDateTime(long millisec) {
        Instant instant = Instant.ofEpochMilli(millisec);
        ZoneId zone = ZoneId.systemDefault(); // local Zone
        return LocalDateTime.ofInstant(instant, zone);
    }
    
    static long localDateTime_to_Milliseconds(LocalDateTime dt) {
        return Instant.from(dt).toEpochMilli();
    }
    
    // LocalDateTime chi co tinh TUONG DOI, khong gan lien voi Zone tuyet doi nao ca
    // LocalDateTime run tren computer o VietNam se lay Zone = +7
    // LocalDateTime run tren computer o England se lay Zone = 0
    // Instant va ZonedDateTime co tinh TUYET DOI
    static Instant localDateTime_to_Instant1(LocalDateTime time) {
        ZonedDateTime zonedDateTime = time.atZone(ZoneId.systemDefault());
        return zonedDateTime.toInstant();
    }
    
    static Instant localDateTime_to_Instant2(LocalDateTime time) {
        ZonedDateTime zonedDateTime = time.atZone(ZoneId.systemDefault());
        return Instant.from(zonedDateTime);
    }
    
}
