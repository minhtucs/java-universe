package juniverse.solid.ocp.bad2;

/**
 *
 * @author tunm2
 */
public class Order {
    
    static enum Shipping { TWO_HOURS, NORMAL }
    
    private Shipping shipping;
    
    /**
     * Flaw: when new shipping method added, we have to modify this method to adapt
     */
    public double getShipingCost() {
        switch (shipping) {
            case TWO_HOURS:
                return 30000;
            case NORMAL:
                return 10000;
            default:
                throw new IllegalStateException();
        }
    }
    
}
