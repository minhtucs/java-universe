package juniverse.patterns.visitor.bad.expression.procedural;

/**
 *
 * @author tunm2
 */
public class ExpressionEvaluator {
    
    public int evaluate(Expression exp) {
        switch (exp.op) {
            case LITERAL: 
                return exp.value;
            case ADD:
                return evaluate(exp.left) + evaluate(exp.right);
            case SUBTRACT:
                return evaluate(exp.left) - evaluate(exp.right);
            case MULTIPLY:
                return evaluate(exp.left) * evaluate(exp.right);
            case DIVIDE:
                return evaluate(exp.left) / evaluate(exp.right);
            default:
                throw new UnsupportedOperationException();
        }
    }

}
