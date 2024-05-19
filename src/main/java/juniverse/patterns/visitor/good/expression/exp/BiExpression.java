package juniverse.patterns.visitor.good.expression.exp;

/**
 *
 * @author tunm2
 */
public abstract class BiExpression implements Expression {
    
    public Expression left;
    public Expression right;

    public BiExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
}
