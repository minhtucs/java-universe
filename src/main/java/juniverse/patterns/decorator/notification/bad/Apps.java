package juniverse.patterns.decorator.notification.bad;

import juniverse.patterns.decorator.notification.Client1;
import juniverse.patterns.decorator.notification.Client2;

/**
 * 
 * @author tunm2
 */
public class Apps {
    
    public static void main(String[] args) {
        Object user = "Ranky";
        String message = "Hello Ranky!";
        
        Client1 app1 = new Client1(new EmailAndSmsNotifier());
        app1.notify(user, message);
        
        Client2 app2 = new Client2(new EmailAndZaloNotifier());
        app2.notify(user, message);
    }
    
}