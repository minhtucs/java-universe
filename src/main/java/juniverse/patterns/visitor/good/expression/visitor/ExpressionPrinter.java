package juniverse.patterns.visitor.good.expression.visitor;

import juniverse.patterns.visitor.good.expression.exp.AddExpression;
import juniverse.patterns.visitor.good.expression.exp.Expression;
import juniverse.patterns.visitor.good.expression.exp.LiteralExpression;
import juniverse.patterns.visitor.good.expression.exp.MultiplyExpression;

/**
 *
 * @author tunm2
 */
public class ExpressionPrinter implements ExpressionVisitor<String> {
    
    public String visit(Expression exp) {
        return exp.accept(this);
    }

    @Override
    public String visit(LiteralExpression exp) {
        return String.valueOf(exp.value);
    }

    @Override
    public String visit(AddExpression exp) {
        return "(" + visit(exp.left) + " + " + visit(exp.right) + ")";
    }

    @Override
    public String visit(MultiplyExpression exp) {
        return "(" + visit(exp.left) + " * " + visit(exp.right) + ")";
    }


    

}
