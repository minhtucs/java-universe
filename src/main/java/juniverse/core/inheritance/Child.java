package juniverse.core.inheritance;

/**
 *
 * @author tunm2
 */
public class Child extends Parent {
    
    private String message = "hello overrdie";

    public Child() {
        super();
        System.err.println("Child.constructor()");
    }

    // In the parent's constructor, this is called before initializing "message"
    // so message here is null
    @Override
    protected void doOverride() {
        System.err.println("doOverride: " + message);
    }

}
