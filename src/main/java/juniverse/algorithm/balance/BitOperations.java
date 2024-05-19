package juniverse.algorithm.balance;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author tunm2
 */
public class BitOperations {
    
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 1, 4, 3, 3, 1, 3};
        int single = findSingleNumber1(arr);
        System.out.println(single);
        
        int n = 1234;
        int cp = n ^ 0;
        System.out.println(cp);
    }
    
    static int findSingleNumber1(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }
    
    static int findSingleNumber2(int arr[]) {
        Set<Integer> set = new HashSet<>(arr.length);
        for (int el : arr) {
            if (!set.add(el)) 
                set.remove(el);
        }
        
        Iterator<Integer> iter = set.iterator();
        return iter.next();
    }
}
