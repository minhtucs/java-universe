package juniverse.patterns.factorymethod.creator;

import juniverse.patterns.factorymethod.product.Employee;

/**
 *
 * @author Tu Nguyen
 */
public abstract class EmployeeFactory {
    
    public abstract Employee makeEmployee();
    
}
