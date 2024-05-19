package juniverse.patterns.decorator.notification.bad;

import juniverse.patterns.decorator.notification.Notifier;

/**
 * Added later due to client's demand
 * 
 * @author tunm2
 */
public class ZaloNotifier implements Notifier {
    
    @Override
    public void notify(Object user, String message) {
        System.err.println(String.format("Send %s via zalo to %s", message, user));
    }
    
}
