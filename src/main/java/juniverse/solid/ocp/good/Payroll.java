package juniverse.solid.ocp.good;

import java.util.Date;

/**
 *
 * @author tunm2
 */
public class Payroll {
    
    public boolean isPayDay(Employee employee, Date date) {
        return employee.isPayDay(date);
    }
    
    public double calculatePay(Employee employee) {
        return employee.calculatePay();
    }
    
}
