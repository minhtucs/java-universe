package juniverse.core.concurrency.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author tunm2
 */
public class JavaSemaphoreTest {
    
    java.util.concurrent.locks.Lock lock = new ReentrantLock();
    java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(1);
    
    public static void main(String[] args) throws InterruptedException {
        JavaSemaphoreTest tester = new JavaSemaphoreTest();
//        tester.testLockWith2Threads();
//        tester.testSemaphoreSameThread();
        tester.testSemaphoreWith2Threads();
    }
    
    void testLockSameThread() {
        lock.lock();
        System.out.println("acquired lock 1");
        lock.lock();
        System.out.println("acquired lock 2");
    }
    
    void testLockWith2Threads() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("thread1 acquired lock & sleeping...");
                try { Thread.sleep(5000); } catch (Exception e) {}
                lock.unlock();
                System.out.println("thread1 released lock");
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 waiting...");
                lock.lock();
                System.out.println("thread2 acquired lock");
            }
        });
        
        thread1.start();
        thread2.start();
        
        lock.unlock();
    }
    
    void testSemaphoreSameThread() throws InterruptedException {
        semaphore.acquire(1);
        System.out.println("acquired semaphore 1");
        semaphore.acquire(1);
        System.out.println("acquired semaphore 2");
    }
    
    void testSemaphoreWith2Threads() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire(1);
                } catch (InterruptedException ex) {}
                System.out.println("thread1 acquired 1 semaphore & sleeping...");
                
                try { Thread.sleep(5000); } catch (Exception e) {}
                
                semaphore.release(1);
                System.out.println("thread1 released 1 semaphore");
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 waiting...");
                try {
                    semaphore.acquire(1);
                } catch (InterruptedException ex) {}
                System.out.println("thread2 acquired 1 semaphore");
            }
        });
        
        thread1.start();
        thread2.start();
        
        semaphore.release(1);
    }
}
