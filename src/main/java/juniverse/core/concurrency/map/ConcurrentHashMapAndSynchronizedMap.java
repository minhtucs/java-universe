package juniverse.core.concurrency.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author tunm2
 */
public class ConcurrentHashMapAndSynchronizedMap {
    
    public static void main(String[] args) {
        
    }
    
    static void testConcurrentHashMap() {
        int initialCapacity = 1000;
        float loadFactor = 0.75F;
        int concurrencyLevel = 16; // what
        
        Map<Integer, Integer> map = new ConcurrentHashMap(initialCapacity, loadFactor, concurrencyLevel);
    }
    
}
