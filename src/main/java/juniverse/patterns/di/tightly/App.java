package juniverse.patterns.di.tightly;

/**
 * Always have to move by car.
 * Any change requires a modification of class Traveler
 * 
 * @author tunm2
 */
public class App {
    
    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        traveler.startJourney();
    }
    
}
