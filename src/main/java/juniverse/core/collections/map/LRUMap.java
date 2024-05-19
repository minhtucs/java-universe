package juniverse.core.collections.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 *
 * @author tunm2
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {
    
    private int lruSize;
    
    public LRUMap(int initialSize) {
        super(initialSize, 0.75F, true);
        this.lruSize = initialSize;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > this.lruSize;
    }   
}