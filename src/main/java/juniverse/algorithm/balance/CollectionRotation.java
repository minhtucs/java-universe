
package juniverse.algorithm.balance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author tunm2
 */
public class CollectionRotation {
    static AtomicLong NUM = new AtomicLong();
    static final List<Integer> LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Long current = NUM.incrementAndGet();
            List<Integer> list = new ArrayList<>(LIST.size());
            list.addAll(LIST);
            
            int distance = (int) (current % LIST.size());
            Collections.rotate(list, distance);
            System.out.println(list);
        }
    }
    
}
