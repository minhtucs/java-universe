package juniverse.solid.srp.rectangle.bad;

/**
 *
 * @author Tu Nguyen
 */
public class Rectangle {
    
    double x, y;
    
    void draw() {
        // draw rectangle on UI
    }
    
    double area() {
        return x * y;
    }
    
    double perimeter() {
        return 2 * (x + y);
    }
}
