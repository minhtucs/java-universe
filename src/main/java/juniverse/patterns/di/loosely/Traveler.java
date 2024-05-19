package juniverse.patterns.di.loosely;

/**
 *
 * @author tunm2
 */
public class Traveler {
    
    private Vehicle vehicle;
    
    public Traveler() {}
    
    public Traveler(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public void startJourney() {
        vehicle.move();
    }
    
}
