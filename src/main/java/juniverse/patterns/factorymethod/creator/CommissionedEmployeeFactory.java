package juniverse.patterns.factorymethod.creator;

import juniverse.patterns.factorymethod.product.CommissionedEmployee;
import juniverse.patterns.factorymethod.product.Employee;

/**
 *
 * @author Tu Nguyen
 */
public class CommissionedEmployeeFactory extends EmployeeFactory {

    @Override
    public Employee makeEmployee() {
        return new CommissionedEmployee();
    }

}
