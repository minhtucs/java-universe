package juniverse.patterns.decorator.pizzashop.good;

import juniverse.patterns.decorator.pizzashop.Pizza;

/**
 *
 * @author Tu Nguyen
 */
public abstract class PizzaDecorator implements Pizza {
    
    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    
    @Override
    public String make() {
        return pizza.make() + addExtraMaterial();
    }

    public abstract String addExtraMaterial();
}
