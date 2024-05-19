package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.VegetablePizza;

/**
 *
 * @author Tu Nguyen
 */
public class PepperVegetablePizza extends VegetablePizza {

    @Override
    public String make() {
        return super.make() + addPepper();
    }
    
    public String addPepper() {
        return " with pepper";
    }
}
