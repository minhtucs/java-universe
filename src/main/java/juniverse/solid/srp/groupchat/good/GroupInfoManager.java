package juniverse.solid.srp.groupchat.good;

import juniverse.solid.srp.groupchat.Group;
import juniverse.solid.srp.groupchat.Member;

/**
 *
 * @author Tu Nguyen
 */
public abstract class GroupInfoManager {
    
    abstract void changeName(Group group, String newName);
    
    abstract void changeAdmin(Group group, Member newAdmin);
    
}
