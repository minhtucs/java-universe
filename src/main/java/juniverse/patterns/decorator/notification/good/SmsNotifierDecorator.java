package juniverse.patterns.decorator.notification.good;

import juniverse.patterns.decorator.notification.Notifier;

/**
 * 
 * @author tunm2
 */
public class SmsNotifierDecorator extends NotifierDecorator {

    public SmsNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void addNotify(Object user, String message) {
        System.err.println(String.format("Send %s via SMS to %s", message, user));
    }
    
}
