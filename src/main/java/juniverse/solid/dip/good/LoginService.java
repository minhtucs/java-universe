package juniverse.solid.dip.good;

/**
 *
 * @author Tu Nguyen
 */
public class LoginService {
    
    MessageSender msgSender;

    public LoginService(MessageSender msgSender) {
        this.msgSender = msgSender;
    }
    
    void login(String userId, String password) {
        // handle login
        msgSender.sendMessage(userId, "You just logged in to iChat");
    }
    
}
