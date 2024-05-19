package juniverse.core.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tunm2
 */
public class NewDate {
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            LocalDateTime dt = LocalDateTime.now();
            System.err.println(dt.getMinute() + ":" + dt.getSecond() + ":" + dt.getNano()/1000000);
            Thread.sleep(10);
        }
    }
    
    static void createDate() {
        LocalDate dob = LocalDate.of(1991, Month.JUNE, 19);
        LocalDate now = LocalDate.now();
        
        System.err.println(now);
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.err.println(age);
    }
    
    static void parseFromString() {
        String sDate = "2019-07-01";
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(sDate, pattern);
        System.err.println(date);
    }
    
}
