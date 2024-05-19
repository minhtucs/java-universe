package juniverse.algorithm.balance;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author tunm2
 */
public class RandomUsage {
    public static void main(String[] args) {
        Random rangen = new Random(System.currentTimeMillis());
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < 100; i++) {
            int num = rangen.nextInt(100);
            set.add(num);
        }
        
        System.out.println(set.size());
    }
}
