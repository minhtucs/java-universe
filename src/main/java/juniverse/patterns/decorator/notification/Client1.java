package juniverse.patterns.decorator.notification;

/** 
 * At the beginning, it only need to notify via Email, but now it wants to notify both Email & SMS.
 * So, it could modify codes to support a list of Notifiers: List<Notifier> notifiers -> NOT GOOD
 *
 * @author tunm2
 */
public class Client1 {
    
    private Notifier notifier;
    
    public Client1(Notifier notifier) {
        this.notifier = notifier;
    }
    
    public void notify(Object user, String message) {
        this.notifier.notify(user, message);
    }
}
