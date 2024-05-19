package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.VegetablePizza;

/**
 *
 * @author Tu Nguyen
 */
public class CheeseVegetablePizza extends VegetablePizza {

    @Override
    public String make() {
        return super.make() + addCheese();
    }
    
    public String addCheese() {
        return " with cheese";
    }
    
}
