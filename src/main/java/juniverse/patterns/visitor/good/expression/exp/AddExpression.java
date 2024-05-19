package juniverse.patterns.visitor.good.expression.exp;

import juniverse.patterns.visitor.good.expression.visitor.ExpressionVisitor;

/**
 *
 * @author tunm2
 */
public class AddExpression extends BiExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <R> R accept(ExpressionVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
}
