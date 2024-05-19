package juniverse.patterns.factorymethod;

import juniverse.patterns.factorymethod.creator.CommissionedEmployeeFactory;
import juniverse.patterns.factorymethod.creator.EmployeeFactory;
import juniverse.patterns.factorymethod.product.Employee;

/**
 *
 * @author Tu Nguyen
 */
public class App {
    
    public static void main(String[] args) {
        EmployeeFactory factory = new CommissionedEmployeeFactory();
        Employee employee = factory.makeEmployee();
    }
    
}
