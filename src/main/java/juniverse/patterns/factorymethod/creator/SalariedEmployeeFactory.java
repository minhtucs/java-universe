package juniverse.patterns.factorymethod.creator;

import juniverse.patterns.factorymethod.product.SalariedEmployee;
import juniverse.patterns.factorymethod.product.Employee;

/**
 *
 * @author Tu Nguyen
 */
public class SalariedEmployeeFactory extends EmployeeFactory {

    @Override
    public Employee makeEmployee() {
        return new SalariedEmployee();
    }

}
