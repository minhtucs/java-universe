package juniverse.solid.ocp.good2;

/**
 *
 * @author tunm2
 */
public class NormalShipping implements Shipping {

    @Override
    public double getCost(Order order) {
        return 10000;
    }
    
}
