package juniverse.core.concurrency.semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Semaphore is often used to restrict the number of threads that can access some resource.
 * In this case, we use semaphore to control the number of accesses to a pool
 * 
 * @author tunm2
 */
public class PoolAccessControl {
    
    // permits
    private static final int MAX_AVAILABLE_PERMITS = 100;
    
    private Semaphore available = new Semaphore(MAX_AVAILABLE_PERMITS, true);
    
    private BlockingQueue<Object> pool = new ArrayBlockingQueue<>(Integer.MAX_VALUE);
    
    public Object getItem() throws InterruptedException {
        // get a permit.
        // if a permit available, decrease the available permits by 1 and continue
        // if no permit available, block until got one
        available.acquire();
        // get and remove item from pool
        return pool.poll();
    }
    
    public void returnItem(Object item) {
        // put item to pool
        pool.add(item);
        // increase the available permits and notify to any blocking thread
        available.release();
    }
}
