package juniverse.solid.srp.rectangle.good;

/**
 *
 * @author Tu Nguyen
 */
public class RectangleCalculator {
    
    double area(Rectangle rec) {
        return rec.x * rec.y;
    }
    
    double perimeter(Rectangle rec) {
        return 2 * (rec.x + rec.y);
    }
    
}
