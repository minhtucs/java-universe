package juniverse.patterns.visitor.bad.expression.oop;

/**
 *
 * @author tunm2
 */
public class App {
    
    // (2 + 1) * 3
    public static void main(String[] args) {
        Expression left = build2plus1();
        Expression right = new LiteralExpression(3);
        MultiplyExpression exp = new MultiplyExpression(left, right);
        
        final ExpressionEvaluator expEvaluator = new ExpressionEvaluator();
        int evaluated = expEvaluator.evaluate(exp);
        System.err.println(evaluated);
        
        ExpressionPrinter expPrinter = new ExpressionPrinter();
        expPrinter.print(exp);
    }
    
    static Expression build2plus1() {
        final Expression left = new LiteralExpression(2);
        final Expression right = new LiteralExpression(1);
        return new AddExpression(left, right);
    }
}
