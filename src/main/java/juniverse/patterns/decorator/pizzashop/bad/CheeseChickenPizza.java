package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.ChickenPizza;

/**
 *
 * @author Tu Nguyen
 */
public class CheeseChickenPizza extends ChickenPizza {
    
    @Override
    public String make() {
        return super.make() + addCheese();
    }
    
    public String addCheese() {
        return " with cheese";
    }
    
}
