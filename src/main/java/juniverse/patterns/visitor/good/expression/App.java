package juniverse.patterns.visitor.good.expression;

import juniverse.patterns.visitor.good.expression.exp.AddExpression;
import juniverse.patterns.visitor.good.expression.exp.Expression;
import juniverse.patterns.visitor.good.expression.exp.LiteralExpression;
import juniverse.patterns.visitor.good.expression.exp.MultiplyExpression;
import juniverse.patterns.visitor.good.expression.visitor.ExpressionEvaluator;
import juniverse.patterns.visitor.good.expression.visitor.ExpressionPrinter;

/**
 *
 * @author tunm2
 */
public class App {
    
    // (2 + 1) * 3
    public static void main(String[] args) {
        Expression left = build2plus1();
        Expression right = new LiteralExpression(3);
        Expression exp = new MultiplyExpression(left, right);
        
        final ExpressionEvaluator expEvaluator = new ExpressionEvaluator();
        int evaluated = expEvaluator.visit(exp);
        System.err.println(evaluated);
        
        ExpressionPrinter expPrinter = new ExpressionPrinter();
        System.err.println(expPrinter.visit(exp));
    }
    
    static Expression build2plus1() {
        final Expression left = new LiteralExpression(2);
        final Expression right = new LiteralExpression(1);
        return new AddExpression(left, right);
    }
    
}
