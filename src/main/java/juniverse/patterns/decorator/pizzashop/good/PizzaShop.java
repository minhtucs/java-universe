package juniverse.patterns.decorator.pizzashop.good;

import juniverse.patterns.decorator.pizzashop.ChickenPizza;
import juniverse.patterns.decorator.pizzashop.Pizza;
import juniverse.patterns.decorator.pizzashop.TomatoPizza;
import juniverse.patterns.decorator.pizzashop.VegetablePizza;

/**
 *
 * @author Tu Nguyen
 */
public class PizzaShop {
    
    public void makePepperVegetable() {
        Pizza pepperVegetablePizza = new VegetablePizza();
        pepperVegetablePizza = new PepperDecorator(pepperVegetablePizza);
        System.out.println(pepperVegetablePizza.make());
    }

    public void makePepperTomato() {
        Pizza pepperTomatoPizza = new TomatoPizza();
        pepperTomatoPizza = new PepperDecorator(pepperTomatoPizza);
        System.out.println(pepperTomatoPizza.make());
    }

    public void makePepperChicken() {
        Pizza pepperChickenPizza = new ChickenPizza();
        pepperChickenPizza = new PepperDecorator(pepperChickenPizza);
        System.out.println(pepperChickenPizza.make());
    }

    public void makeCheeseVegetable() {
        Pizza cheeseVegetablePizza = new VegetablePizza();
        cheeseVegetablePizza = new CheeseDecorator(cheeseVegetablePizza);
        System.out.println(cheeseVegetablePizza.make());
    }

    public void makeCheeseTomato() {
        Pizza cheeseTomatoPizza = new TomatoPizza();
        cheeseTomatoPizza = new CheeseDecorator(cheeseTomatoPizza);
        System.out.println(cheeseTomatoPizza.make());
    }

    public void makeCheeseChicken() {
        Pizza cheeseChickenPizza = new ChickenPizza();
        cheeseChickenPizza = new CheeseDecorator(cheeseChickenPizza);
        System.out.println(cheeseChickenPizza.make());
    }
    
    public void makePepperCheeseVegetable() {
        Pizza pepperCheeseVegetablePizza = new VegetablePizza();
        pepperCheeseVegetablePizza = new CheeseDecorator(pepperCheeseVegetablePizza);
        pepperCheeseVegetablePizza = new PepperDecorator(pepperCheeseVegetablePizza);
        System.out.println(pepperCheeseVegetablePizza.make());
    }

    public void makePepperCheeseTomato() {
        Pizza pepperCheeseTomatoPizza = new TomatoPizza();
        pepperCheeseTomatoPizza = new CheeseDecorator(pepperCheeseTomatoPizza);
        pepperCheeseTomatoPizza = new PepperDecorator(pepperCheeseTomatoPizza);
        System.out.println(pepperCheeseTomatoPizza.make());
    }

    public void makePepperCheeseChicken() {
        Pizza pepperCheeseChickenPizza = new ChickenPizza();
        pepperCheeseChickenPizza = new CheeseDecorator(pepperCheeseChickenPizza);
        pepperCheeseChickenPizza = new PepperDecorator(pepperCheeseChickenPizza);
        System.out.println(pepperCheeseChickenPizza.make());
    }
    
}
