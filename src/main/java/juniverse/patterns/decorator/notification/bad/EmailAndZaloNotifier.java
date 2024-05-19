package juniverse.patterns.decorator.notification.bad;

import juniverse.patterns.decorator.notification.Notifier;

/**
 *
 * @author tunm2
 */
public class EmailAndZaloNotifier implements Notifier {

    @Override
    public void notify(Object user, String message) {
        System.err.println(String.format("Send %s via Email to %s", message, user));
        System.err.println(String.format("Send %s via Zalo to %s", message, user));
    }
    
}
