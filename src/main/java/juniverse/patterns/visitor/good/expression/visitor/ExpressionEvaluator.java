package juniverse.patterns.visitor.good.expression.visitor;

import juniverse.patterns.visitor.good.expression.exp.AddExpression;
import juniverse.patterns.visitor.good.expression.exp.Expression;
import juniverse.patterns.visitor.good.expression.exp.LiteralExpression;
import juniverse.patterns.visitor.good.expression.exp.MultiplyExpression;

/**
 *
 * @author tunm2
 */
public class ExpressionEvaluator implements ExpressionVisitor<Integer> {
    
    public Integer visit(Expression exp) {
        return exp.accept(this);
    }
    
    @Override
    public Integer visit(LiteralExpression exp) {
        return exp.value;
    }

    @Override
    public Integer visit(AddExpression exp) {
        return visit(exp.left) + visit(exp.right);
    }

    @Override
    public Integer visit(MultiplyExpression exp) {
        return visit(exp.left) * visit(exp.right);
    }


}
