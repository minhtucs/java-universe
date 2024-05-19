package juniverse.patterns.visitor.good.expression.exp;

import juniverse.patterns.visitor.good.expression.visitor.ExpressionVisitor;

/**
 *
 * @author tunm2
 */
public interface Expression {
    
    <R> R accept(ExpressionVisitor<R> visitor);
    
}
