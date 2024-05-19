package juniverse.core.concurrency.sync;

/**
 *
 * @author tunm2
 */
public class LockTest {
    
    public static void main(String[] args) {
        Lock lock = new Lock();

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
    }
}