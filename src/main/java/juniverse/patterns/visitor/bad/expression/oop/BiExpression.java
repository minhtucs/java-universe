package juniverse.patterns.visitor.bad.expression.oop;

/**
 *
 * @author tunm2
 */
public abstract class BiExpression implements Expression {

    public Expression left;
    public Expression right;

    public BiExpression() {
    }

    public BiExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return evaluateOperator(left.evaluate(), right.evaluate());
    }
    
    public abstract int evaluateOperator(int leftValue, int rightValue);

    @Override
    public String print() {
        return "(" + left.print() + " " + printOperator() + " " + right.print() + ")";
    }

    public abstract String printOperator();
}
