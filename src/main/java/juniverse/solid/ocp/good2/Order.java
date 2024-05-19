package juniverse.solid.ocp.good2;

/**
 *
 * @author tunm2
 */
public class Order {

    /** Just inject any Shipping method */
    private Shipping shipping;

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }
    
    public double getShippingCost() {
        return this.shipping.getCost(this);
    }
    
}