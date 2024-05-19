package juniverse.solid.ocp.good2;

/**
 *
 * @author tunm2
 */
public class TwoHoursShipping implements Shipping {

    @Override
    public double getCost(Order order) {
        return 30000;
    }
    
}
