package juniverse.patterns.decorator.pizzashop.good;

import juniverse.patterns.decorator.pizzashop.Pizza;

/**
 *
 * @author Tu Nguyen
 */
public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    
    @Override
    public String addExtraMaterial() {
        return " with cheese";
    }

}
