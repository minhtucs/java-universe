package juniverse.patterns.strategy.navigator.good;

import juniverse.patterns.strategy.navigator.Point;
import juniverse.patterns.strategy.navigator.Route;

/**
 *
 * @author Tu Nguyen
 */
public interface RoutingStrategy {
    
    Route route(Point from, Point to);
    
}
