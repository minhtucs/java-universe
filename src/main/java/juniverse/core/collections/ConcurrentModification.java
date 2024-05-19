package juniverse.core.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Why remove on Iterator of collections is allowed.
 *   Each collection has a variable "modCount" to track of modification count on collection
 *   When loop over collection, in essence, it loop over the Iterator.
 *   Each collection must implement the Iterable interface which has method return Iterator
 *   Each iterator has variable expectedModCount which must equal to modCount on each loop operation
 *   if not, then throw ConcurrentModificationException
 * 
 * @author tunm2
 */
public class ConcurrentModification {
    
    static final Map<Integer, Integer> map = new ConcurrentHashMap<>();
    static final List<Integer> list = new Stack<>();
    
    static {
        for (int i = 0; i < 10; i++) {
            list.add(i);
            map.put(i, i);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("map before: " + map);
        removeMapEntryOnLoopOverIterator();
        System.out.println("map after: " + map);
        
        
        System.out.println("list before: " + list);
//        removeOnLoopList();
        removeListItemOnLoopOverIterator();
        System.out.println("list after: " + list);
    }
    
    static void removeListItemOnLoopOverIterator() {
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer item = iter.next();
            if (item % 2 == 0)
                iter.remove();
        }
    }
    
    static void removeListItemOnLoopList() {
        for (Integer item : list) {
            if (item % 2 == 0)
                list.remove(item);
        }
    }
    
    static void removeMapEntryOnLoopOverIterator() {
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            if (key % 2 == 0)
                iter.remove();
        }
    }   
}
