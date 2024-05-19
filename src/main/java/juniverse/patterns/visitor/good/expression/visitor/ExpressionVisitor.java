package juniverse.patterns.visitor.good.expression.visitor;

import juniverse.patterns.visitor.good.expression.exp.AddExpression;
import juniverse.patterns.visitor.good.expression.exp.LiteralExpression;
import juniverse.patterns.visitor.good.expression.exp.MultiplyExpression;

/**
 *
 * @author tunm2
 */
public interface ExpressionVisitor<R> {
    
    R visit(LiteralExpression exp);
    
    R visit(AddExpression exp);
    
    R visit(MultiplyExpression exp);
}
