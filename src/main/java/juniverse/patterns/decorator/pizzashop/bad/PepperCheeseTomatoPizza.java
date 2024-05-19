package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.TomatoPizza;

/**
 *
 * @author Tu Nguyen
 */
public class PepperCheeseTomatoPizza extends TomatoPizza {

    @Override
    public String make() {
        return super.make() + addCheese() + addPepper();
    }
    
    public String addCheese() {
        return " with cheese";
    }
    
    public String addPepper() {
        return " with pepper";
    }
}
