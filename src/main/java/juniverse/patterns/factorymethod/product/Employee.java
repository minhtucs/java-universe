package juniverse.patterns.factorymethod.product;

import juniverse.patterns.factorymethod.Money;

/**
 *
 * @author Tu Nguyen
 */
public class Employee {
    
    public boolean isPayDay() {
        return false;
    }
    
    public Money calculatePay() {
        return new Money();
    }
    
    public void deliverPay(Money pay) {
        
    }
}
