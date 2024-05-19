package juniverse.patterns.visitor.bad.expression.procedural;

/**
 *
 * @author tunm2
 */
public class App {
    
    // (2 + 1) * 3
    public static void main(String[] args) {
        Expression left = build2plus1();
        Expression right = new Expression(Operator.LITERAL, 3);
        Expression exp = new Expression(Operator.MULTIPLY, left, right);
        
        ExpressionEvaluator expEvaluator = new ExpressionEvaluator();
        int evaluated = expEvaluator.evaluate(exp);
        System.err.println(evaluated);
        
        ExpressionPrinter printer = new ExpressionPrinter();
        System.err.println(printer.print(exp));
    }
    
    static Expression build2plus1() {
        Expression left = new Expression(Operator.LITERAL, 2);
        Expression right = new Expression(Operator.LITERAL, 1);
        return new Expression(Operator.ADD, left, right);
    }
}
