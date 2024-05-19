package juniverse.patterns.observable;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author tunm2
 */
public class UserRegistrationObservable {

    Observable observable = new Observable();
    
    public void addObserver(Observer observer) {
        this.observable.addObserver(observer);
    }
    
    public void register(User user) {
        // do register logic
        // notify all observers
        observable.notifyObservers(user);
    }
    
}
