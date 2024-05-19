package juniverse.solid.dip.bad;

/**
 *
 * @author Tu Nguyen
 */
public class LoginService {
    
    SmsSender smsSender;

    public LoginService(SmsSender smsSender) {
        this.smsSender = smsSender;
    }
    
    void login(String userId, String password) {
        // handle login
        smsSender.sendMessage(userId, "You just logged in to iChat");
    }
    
}
