package juniverse.patterns.decorator.notification.good;

import juniverse.patterns.decorator.notification.Notifier;

/**
 *
 * @author tunm2
 */
public class ZaloNotifierDecorator extends NotifierDecorator {

    public ZaloNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void addNotify(Object user, String message) {
        System.err.println(String.format("Send %s via Zalo to %s", message, user));
    }
    
}