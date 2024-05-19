package juniverse.patterns.decorator.notification.good;

import juniverse.patterns.decorator.notification.Client1;
import juniverse.patterns.decorator.notification.Client2;
import juniverse.patterns.decorator.notification.EmailNotifier;
import juniverse.patterns.decorator.notification.Notifier;

/**
 *
 * @author tunm2
 */
public class Apps {
    
    public static void main(String[] args) {
        Object user = "Ranky";
        String message = "Hello Ranky!";
        
        Notifier emailNotifier = new EmailNotifier();
        
        Notifier emailSmsNotifier = new SmsNotifierDecorator(emailNotifier);
        Client1 app1 = new Client1(emailSmsNotifier);
        app1.notify(user, message);
        
        Notifier emailZaloNotifier = new ZaloNotifierDecorator(emailNotifier);
        Client2 app2 = new Client2(emailZaloNotifier);
        app2.notify(user, message);
        
        // now I want to notify only SMS, or Zalo, HOW??
    }
    
}
