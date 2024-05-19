package juniverse.patterns.decorator.notification;

/**
 * At the beginning, only email notifier is supported
 * 
 * @author tunm2
 */
public class EmailNotifier implements Notifier {

    @Override
    public void notify(Object user, String message) {
        System.err.println(String.format("Send %s via Email to %s", message, user));
    }

}