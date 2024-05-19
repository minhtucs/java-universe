package juniverse.patterns.observable;

/**
 *
 * @author tunm2
 */
public class App {
    
    public static void main(String[] args) {
        UserRegistrationObservable userRegistra = new UserRegistrationObservable();
        userRegistra.addObserver(new LoggerObserver());
        userRegistra.addObserver(new MailSenderObserver());
        
        userRegistra.register(new User(1, "user 1", "user1@email.com"));
    }
    
}