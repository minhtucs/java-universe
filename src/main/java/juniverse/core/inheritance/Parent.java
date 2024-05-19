package juniverse.core.inheritance;

/**
 * Call overridable method in constructor is prone to bug
 * https://stackoverflow.com/questions/3404301/whats-wrong-with-overridable-method-calls-in-constructors
 * 
 * @author tunm2
 */
public abstract class Parent {

    public Parent() {
        System.err.println("Parent.constructor()");
        this.doOverride();
    }
    
    protected abstract void doOverride();
    
}
