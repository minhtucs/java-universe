package juniverse.patterns.decorator.pizzashop.good;

import juniverse.patterns.decorator.pizzashop.Pizza;

/**
 *
 * @author Tu Nguyen
 */
public class PepperDecorator extends PizzaDecorator {

    public PepperDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String addExtraMaterial() {
        return " with pepper";
    }

}
