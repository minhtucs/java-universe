package juniverse.core.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author tunm2
 */
public class JavaReentrantLocks {
    
    private static final Lock lock = new ReentrantLock();
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            lock.lock();
            try { Thread.sleep(2000); } catch (InterruptedException ex) {}
            lock.unlock();
        }).start();
        Thread.sleep(3000);
//        lock();
        lockInterruptibly();
//        tryLock();
//        tryLockTimeout();
    }
    
    // waiting until acquire lock
    static void lock() {
        System.err.println("trying to acquire lock until get it");
        lock.lock();
        System.err.println("acquired lock success");
        lock.unlock();
        System.err.println("released lock");
    }
    
    // return true or false immediately 
    static void tryLock() {
        if (lock.tryLock()) {
            System.err.println("acquired lock success");
            lock.unlock();
            System.err.println("released lock");
        } else {
            System.err.println("failed acquire lock");
        }
    }
    
    // return true if acquire success within 2 seconds
    // otherwise, return false when timeout
    static void tryLockTimeout() throws InterruptedException {
        System.err.println("trying to acquire lock within 2 seconds");
        if (lock.tryLock(2, TimeUnit.SECONDS)) {
            try {
                System.err.println("acquired lock success");
            } finally {
                lock.unlock();
                System.err.println("released lock");
            }
        } else {
            System.err.println("failed acquire lock after 2 seconds");
        }
    }
    
    // waiting until acquire lock successfully and ?
    static void lockInterruptibly() throws InterruptedException {
        System.err.println("trying to lock interruptibly");
        lock.lockInterruptibly();
        System.err.println("acquire lock interruptibly success");
    }
    
}
