package juniverse.solid.srp.groupchat.good;

import juniverse.solid.srp.groupchat.Group;

/**
 *
 * @author Tu Nguyen
 */
public abstract class GroupMessageSender {
    
    abstract void sendMessage(Group group, String message);
    
}
