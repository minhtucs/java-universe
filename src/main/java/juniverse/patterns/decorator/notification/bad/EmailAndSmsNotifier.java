package juniverse.patterns.decorator.notification.bad;

import juniverse.patterns.decorator.notification.Notifier;

/**
 *
 * @author tunm2
 */
public class EmailAndSmsNotifier implements Notifier {

    @Override
    public void notify(Object user, String message) {
        System.err.println(String.format("Send %s via Email to %s", message, user));
        System.err.println(String.format("Send %s via SMS to %s", message, user));
    }
    
}
