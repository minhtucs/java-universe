package juniverse.patterns.decorator.pizzashop.bad;

import juniverse.patterns.decorator.pizzashop.Pizza;

/**
 * In this design, we have to implement a lot of classes for new types of Pizza.
 * 
 * @author Tu Nguyen
 */
public class PizzaShop {
    
    public void makePepperVegetable() {
        Pizza pepperVegetablePizza = new PepperVegetablePizza();
        System.out.println(pepperVegetablePizza.make());
    }

    public void makePepperTomato() {
        Pizza pepperTomatoPizza = new PepperTomatoPizza();
        System.out.println(pepperTomatoPizza.make());
    }

    public void makePepperChicken() {
        Pizza pepperChickenPizza = new PepperChickenPizza();
        System.out.println(pepperChickenPizza.make());
    }

    public void makeCheeseVegetable() {
        Pizza cheeseVegetablePizza = new CheeseVegetablePizza();
        System.out.println(cheeseVegetablePizza.make());
    }

    public void makeCheeseTomato() {
        Pizza cheeseTomatoPizza = new CheeseTomatoPizza();
        System.out.println(cheeseTomatoPizza.make());
    }

    public void makeCheeseChicken() {
        Pizza cheeseChickenPizza = new CheeseChickenPizza();
        System.out.println(cheeseChickenPizza.make());
    }
    
    public void makePepperCheeseVegetable() {
        Pizza pepperCheeseVegetablePizza = new PepperCheeseVegetablePizza();
        System.out.println(pepperCheeseVegetablePizza.make());
    }

    public void makePepperCheeseTomato() {
        Pizza pepperCheeseTomatoPizza = new PepperCheeseTomatoPizza();
        System.out.println(pepperCheeseTomatoPizza.make());
    }

    public void makePepperCheeseChicken() {
        Pizza pepperCheeseChickenPizza = new PepperCheeseChickenPizza();
        System.out.println(pepperCheeseChickenPizza.make());
    }
    
}
