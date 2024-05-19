package juniverse.core.concurrency.signal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author tunm2
 */
public class ThreadSignaling3 {
    
    boolean locked = false;
    
    ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    
    public void access() throws InterruptedException {
        if (locked) {
            condition.await();
        }
    }
    
    public void lock() throws InterruptedException {
        locked = true;
    }
    
    public void unlock() {
        locked = false;
        condition.signal();
    }
    
}
