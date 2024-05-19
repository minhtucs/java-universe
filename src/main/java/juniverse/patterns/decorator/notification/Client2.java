package juniverse.patterns.decorator.notification;

/** 
 * At the beginning, it only need to notify via Email, but now it wants to notify both Email & Zalo.
 * So, it could modify codes to support a list of Notifiers: List<Notifier> notifiers -> NOT GOOD
 */
public class Client2 {
    
    private Notifier notifier;
    
    public Client2(Notifier notifier) {
        this.notifier = notifier;
    }
    
    public void notify(Object user, String message) {
        this.notifier.notify(user, message);
    }
}