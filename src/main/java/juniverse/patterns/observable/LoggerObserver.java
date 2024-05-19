package juniverse.patterns.observable;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author tunm2
 */
public class LoggerObserver implements Observer {

    @Override
    public void update(Observable o, Object user) {
        System.err.println("log new user " + user);
    }

}
