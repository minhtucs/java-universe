package juniverse.solid.srp.groupchat.good;

import juniverse.solid.srp.groupchat.Group;
import juniverse.solid.srp.groupchat.Member;

/**
 *
 * @author Tu Nguyen
 */
public abstract class GroupMemberManager {
    
    abstract void addMember(Group group, Member member);
    
    abstract void removeMember(Group group, Member member);
    
}
