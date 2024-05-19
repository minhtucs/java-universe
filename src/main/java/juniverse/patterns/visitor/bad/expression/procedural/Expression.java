package juniverse.patterns.visitor.bad.expression.procedural;

/**
 *
 * @author Tu Nguyen
 */
public class Expression {
   
    public Operator op;
    public Integer value;
    public Expression left;
    public Expression right;

    public Expression(Operator op, Integer value) {
        this.op = op;
        this.value = value;
    }

    public Expression(Operator op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
    
    public Expression(Operator op, Integer value, Expression left, Expression right) {
        this.op = op;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
}
