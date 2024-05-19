package juniverse.patterns.visitor.bad.expression.oop;

/**
 *
 * @author tunm2
 */
public class ExpressionPrinter {
    
    public void print(Expression exp) {
        System.err.println(exp.print());
    }
    
}
