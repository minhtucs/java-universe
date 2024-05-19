package juniverse.patterns.strategy.navigator.good;

import juniverse.patterns.strategy.navigator.Point;
import juniverse.patterns.strategy.navigator.Route;

/**
 *
 * @author Tu Nguyen
 */
public class WalkingRouter implements RoutingStrategy {

    @Override
    public Route route(Point from, Point to) {
        // implement logic finding route by walking
        return new Route();
    }

}
