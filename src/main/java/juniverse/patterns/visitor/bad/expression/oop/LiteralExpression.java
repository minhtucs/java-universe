package juniverse.patterns.visitor.bad.expression.oop;

/**
 *
 * @author tunm2
 */
public class LiteralExpression implements Expression {
    
    public int value;

    public LiteralExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
    
}
