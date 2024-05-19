package juniverse.core.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Nested locks are possible to produce deadlock
 * 
 * @author tunm2
 */
public class Deadlocks {
    
    Lock resource1 = new ReentrantLock(true);
    Lock resource2 = new ReentrantLock(true);
    
    public static void main(String[] args) {
        new Deadlocks().produceDeadlockInCode();
    }
    
    void produceDeadlockInCode() {
        // thread 1
        new Thread(() -> {
            try {
                resource1.lock();
                System.err.println("[thread1] locking on resource 1");
                Thread.sleep(3000);
                
                resource2.lock();
                System.err.println("[thread1] locking on resource 2");
                Thread.sleep(3000);
                System.err.println("[thread1] unlocked resource 2");
                resource2.unlock();
                
                System.err.println("[thread1] unlocked resource 1");
                resource1.unlock();
            } catch (InterruptedException ex) {
            }
        }).start();
        
        // thread 2
        new Thread(() -> {
            try {
                resource2.lock();
                System.err.println("[thread2] locking on resource 2");
                Thread.sleep(3000);
                
                resource1.lock();
                System.err.println("[thread2] locking on resource 1");
                Thread.sleep(3000);
                System.err.println("[thread2] unlocked resource 1");
                resource1.unlock();
                
                System.err.println("[thread2] unlocked resource 2");
                resource2.unlock();
            } catch (InterruptedException ex) {
            }
        }).start();
        
    }
    
    /**
     * https://medium.com/harrys-engineering/atomic-increment-decrement-operations-in-sql-and-fun-with-locks-f7b124d37873
     * To prevent this kind of deadlock:
     *      use deterministic ordering when updating multiple rows => sort row IDs first
     */
    void produceDeadlockInDatabase() {
        new Thread(() -> {
            // beginTransaction();
            // executeSQL("UPDATE tbl_counter SET count = count + 1 WHERE id = 1"); // locking on row id = 1
            // executeSQL("UPDATE tbl_counter SET count = count + 1 WHERE id = 2"); // locking on row id = 2
            // endTransation();
        });
        
        new Thread(() -> {
            // beginTransaction();
            // executeSQL("UPDATE tbl_counter SET count = count + 1 WHERE id = 2"); // locking on row id = 2
            // executeSQL("UPDATE tbl_counter SET count = count + 1 WHERE id = 1"); // locking on row id = 1
            // endTransation();
        });
    }
    
}
