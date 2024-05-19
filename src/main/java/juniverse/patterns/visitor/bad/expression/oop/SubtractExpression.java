package juniverse.patterns.visitor.bad.expression.oop;

/**
 *
 * @author tunm2
 */
public class SubtractExpression extends BiExpression {

    public SubtractExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluateOperator(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }
    
    @Override
    public String printOperator() {
        return "-";
    }
    
}
