package juniverse.solid.srp.groupchat.bad;

import juniverse.solid.srp.groupchat.Group;
import juniverse.solid.srp.groupchat.Member;

/**
 *
 * @author Tu Nguyen
 */
public abstract class GroupManager {
    
    abstract void changeName(Group group, String newName);
    
    abstract void changeAdmin(Group group, Member newAdmin);
    
    abstract void addMember(Group group, Member member);
    
    abstract void removeMember(Group group, Member member);
    
    abstract void sendMessage(Group group, String message);
    
    abstract void storeGroup(Group group);
}
