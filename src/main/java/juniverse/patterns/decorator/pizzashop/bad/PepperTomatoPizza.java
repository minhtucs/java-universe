package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.TomatoPizza;

/**
 *
 * @author Tu Nguyen
 */
public class PepperTomatoPizza extends TomatoPizza {
    
    @Override
    public String make() {
        return super.make() + addPepper();
    }
    
    public String addPepper() {
        return " with pepper";
    }
    
}
