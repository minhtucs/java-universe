package juniverse.core.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tunm2
 */
public class Collections {
    
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set = new HashSet<>();
        set.add(3); set.add(1); set.add(2);
        for (Integer e : set) {
            System.err.println(e);
        }
        AtomicInteger i;
    }
    
    
    static class Task implements Runnable {
        int id;
        int size;
        
        public Task(int id, int size) {
            this.id = id;
            this.size = size;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * size);
                System.err.println(id + " done!");
            } catch (InterruptedException e) {}
        }
    }
}