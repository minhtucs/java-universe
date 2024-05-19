package juniverse.core.collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author tunm2
 */
public class Test {
    
    public static void main(String[] args) {
        TreeSet<Integer> tset = new TreeSet<>(new MyComparator());
        tset.add(1);
        tset.add(2);
        tset.add(5);
        tset.add(0);
        
        for (Integer item : tset) {
            System.out.println(item);
        }
    }
    
    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2))
                return 0;
            return o1 < o2 ? 1 : -1;
        }
    }
    
    static void testHashcodeAndEquals() {
        ObjectKey key1 = new ObjectKey(1, "tu", true);
        ObjectKey key2 = new ObjectKey(1, "tu", false);
        
        System.out.println("key1: " + key1.toString());
        System.out.println("key1.hashcode: " + key1.hashCode());
        System.out.println("key2: " + key2.toString());
        System.out.println("key2.hashcode: " + key2.hashCode());
        
        System.out.println("key1.equals(key2): " + key1.equals(key2));
        System.out.println(0xda);
        
        Map<ObjectKey, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        
        System.out.println(map);
    }
}

