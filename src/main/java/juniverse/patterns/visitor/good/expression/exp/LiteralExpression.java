package juniverse.patterns.visitor.good.expression.exp;

import juniverse.patterns.visitor.good.expression.visitor.ExpressionVisitor;

/**
 *
 * @author tunm2
 */
public class LiteralExpression implements Expression {
    
    public int value;

    public LiteralExpression(int value) {
        this.value = value;
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
}
