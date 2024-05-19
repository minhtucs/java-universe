package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.TomatoPizza;

/**
 *
 * @author Tu Nguyen
 */
public class CheeseTomatoPizza extends TomatoPizza {

    @Override
    public String make() {
        return super.make() + addCheese();
    }
    
    public String addCheese() {
        return " with cheese";
    }
}
