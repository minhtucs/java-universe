package juniverse.patterns.strategy.navigator.good;

import juniverse.patterns.strategy.navigator.Point;
import juniverse.patterns.strategy.navigator.Route;

/**
 *
 * @author Tu Nguyen
 */
public class PublicTransportationRouter implements RoutingStrategy {

    @Override
    // implement logic finding route by public transportation
    public Route route(Point from, Point to) {
        return new Route();
    }
}
