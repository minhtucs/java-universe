package juniverse.core.nio.network.impl;

import java.util.Collection;
import java.util.Set;

public class TSelector {

    private Collection<TSelectableChannel> channels;
    
    /** Registered keys */
    private Set<TSelectionKey> keys;
    /** Selected keys */
    private Set<TSelectionKey> selectedKeys;
    
    public static TSelector open() {
        return new TSelector();
    }
    
    public int select() {
        return 0;
    }
    
    public void wakeUp() {
        
    }
}
