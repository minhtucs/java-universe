package juniverse.patterns.strategy.navigator.bad;

import juniverse.patterns.strategy.navigator.Point;
import juniverse.patterns.strategy.navigator.Route;

/**
 *
 * @author Tu Nguyen
 */
public class TravelNavigator {
    
    Route findRouteByCar(Point from, Point to) {
        // implement logic finding route by car
        return new Route();
    }
    
    Route findRouteByPublicTransportation(Point from, Point to) {
        // implement logic finding route by public transportation
        return new Route();
    }
    
    Route findRouteByWalking(Point from, Point to) {
        // implement logic finding route by walking
        return new Route();
    }
    
    Route findRouteByBicycle(Point from, Point to) {
        // implement logic finding route by bicycle
        return new Route();
    }
    
}
