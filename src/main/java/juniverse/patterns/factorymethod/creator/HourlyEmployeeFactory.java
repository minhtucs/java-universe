package juniverse.patterns.factorymethod.creator;

import juniverse.patterns.factorymethod.product.HourlyEmployee;
import juniverse.patterns.factorymethod.product.Employee;

/**
 *
 * @author Tu Nguyen
 */
public class HourlyEmployeeFactory extends EmployeeFactory {

    @Override
    public Employee makeEmployee() {
        return new HourlyEmployee();
    }

}
