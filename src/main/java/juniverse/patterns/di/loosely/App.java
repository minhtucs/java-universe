package juniverse.patterns.di.loosely;

/**
 * Can flexibly change vehicle without changing the design of class Traveler.
 * 
 * @author tunm2
 */
public class App {
    
    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        
        Vehicle car = new Car();
        traveler.setVehicle(car);
        traveler.startJourney();
        
        Vehicle bike = new Bike();
        traveler.setVehicle(bike);
        traveler.startJourney();
    }   
}