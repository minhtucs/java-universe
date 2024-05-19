package juniverse.solid.ocp.good;

import java.util.Date;

/**
 *
 * @author Tu Nguyen
 */
public interface Employee {
    
    boolean isPayDay(Date date);
    
    double calculatePay();
    
}