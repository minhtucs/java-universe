package juniverse.patterns.visitor.bad.expression.procedural;

/**
 *
 * @author tunm2
 */
public class ExpressionPrinter {
    
    public String print(Expression exp) {
        switch (exp.op) {
            case LITERAL: 
                return String.valueOf(exp.value);
            case ADD:
                return "(" + print(exp.left) + " + " + print(exp.right) + ")";
            case SUBTRACT:
                return "(" + print(exp.left) + " - " + print(exp.right) + ")";
            case MULTIPLY:
                return "(" + print(exp.left) + " * " + print(exp.right) + ")";
            case DIVIDE:
                return "(" + print(exp.left) + " / " + print(exp.right) + ")";
            default:
                throw new UnsupportedOperationException();
        }
    }

    void printOpenBracket() {
        System.out.print("(");
    }
    void printCloseBracket() {
        System.out.print(")");
    }
}
