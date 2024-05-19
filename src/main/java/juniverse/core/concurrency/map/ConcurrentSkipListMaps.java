package juniverse.core.concurrency.map;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 *
 * @author tunm2
 */
public class ConcurrentSkipListMaps {

    static Random random = new Random();
    
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, Object> sortedMap = new ConcurrentSkipListMap<>();
        IntStream.iterate(0, i->i+1).limit(10).forEach(i -> {
            int value = random.nextInt() % 100;
            sortedMap.put(value, value);
        });
        Collections.synchronizedSet(new HashSet<>());
        Semaphore semaphore = new Semaphore(3);
        
        
        System.err.println(sortedMap);
    }
    
}
