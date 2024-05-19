package juniverse.patterns.strategy.navigator.good;

import juniverse.patterns.strategy.navigator.Point;
import juniverse.patterns.strategy.navigator.Route;

/**
 *
 * @author Tu Nguyen
 */
public class App {
    
    public static void main(String[] args) {
        Point from = new Point(0,0);
        Point to = new Point(100,100);
        
        TravelNavigator navigator = new TravelNavigator();
        
        // find route by car
        navigator.setRouter(new CarRouter());
        Route routeByCar = navigator.findRoute(from, to);
        
        // find route by public transportation
        navigator.setRouter(new PublicTransportationRouter());
        Route routeByPT = navigator.findRoute(from, to);
        
        // find route by bicycle
        navigator.setRouter(new BicycleRouter());
        Route routeByBicycle = navigator.findRoute(from, to);
        
        // find route by walking
        navigator.setRouter(new WalkingRouter());
        Route routeByWalking = navigator.findRoute(from, to);
    }
    
}
