package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.ChickenPizza;

/**
 *
 * @author Tu Nguyen
 */
public class PepperChickenPizza extends ChickenPizza {
    
    @Override
    public String make() {
        return super.make() + addPepper();
    }
    
    public String addPepper() {
        return " with pepper";
    }
    
}
