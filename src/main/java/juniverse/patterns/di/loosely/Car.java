package juniverse.patterns.di.loosely;

/**
 *
 * @author tunm2
 */
public class Car implements Vehicle {

    @Override
    public void move() {
        System.out.println("Car move...");
    }
    
}
