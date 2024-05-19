package juniverse.core.concurrency.sync;

/**
 *
 * @author tunm2
 */
public class SemaphoreTest {
    
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.wait(2);
                System.out.println("thread1 acquired semaphore & sleeping...");
                try { Thread.sleep(3000); } catch (Exception e) {}
                semaphore.signal(2);
                System.out.println("thread1 released semaphore");
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 waiting...");
                semaphore.wait(2);
                System.out.println("thread2 acquired semaphore");
            }
        });
        
        thread1.start();
        thread2.start();
    }
}