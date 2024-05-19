package juniverse.patterns.decorator.notification.good;

import juniverse.patterns.decorator.notification.Notifier;

/**
 *
 * @author tunm2
 */
public abstract class NotifierDecorator implements Notifier {
    
    private Notifier notifier;
    
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(Object user, String message) {
        this.notifier.notify(user, message);
        addNotify(user, message);
    }
    
    protected abstract void addNotify(Object user, String message);
}
