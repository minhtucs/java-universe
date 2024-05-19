package juniverse.patterns.strategy.navigator.good;

import juniverse.patterns.strategy.navigator.Point;
import juniverse.patterns.strategy.navigator.Route;

/**
 *
 * @author Tu Nguyen
 */
public class TravelNavigator {
    
    RoutingStrategy router;

    public void setRouter(RoutingStrategy router) {
        this.router = router;
    }
    
    public Route findRoute(Point from, Point to) {
        return router.route(from, to);
    }
    
}
