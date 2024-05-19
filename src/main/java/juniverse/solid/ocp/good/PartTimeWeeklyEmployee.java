package juniverse.solid.ocp.good;

import java.util.Date;

/**
 *
 * @author Tu Nguyen
 */
public class PartTimeWeeklyEmployee implements Employee {
    
    @Override
    public boolean isPayDay(Date date) {
        // check pay day
        return false;
    }

    @Override
    public double calculatePay() {
        // calculate salary
        return 0;
    }

}
