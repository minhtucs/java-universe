package juniverse.solid.ocp.bad;

import java.util.Date;

/**
 *
 * @author Tu Nguyen
 */
public class Payroll {
    
    boolean isPayDay(Employee employee, Date date) {
        switch (employee.type) {
            case FULLTIME:
                // check pay day for full time employee
                break;
            case PARTTIME_HOURLY:
                // check pay day for hourly part time employee
                break;
            case PARTTIME_WEEKLY:
                // check pay day for weekly part time employee
                break;
        }
        return false;
    }
    
    double calculatePay(Employee employee) {
        switch (employee.type) {
            case FULLTIME:
                // calculate pay for full time employee
                break;
            case PARTTIME_HOURLY:
                // calculate pay for hourly part time employee
                break;
            case PARTTIME_WEEKLY:
                // calculate pay for weekly part time employee
                break;
        }
        
        return 0;
    }
    
}
