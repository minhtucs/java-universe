package juniverse.core.concurrency.semaphore;

/**
 *
 * @author tunm2
 */
public class MySemaphores {
    
    /**
     * The waiting thread is always active, not good for CPU utilization
     */
    class Semaphore1 {
        private volatile int available;

        public Semaphore1(int available) {
            this.available = available;
        }

        public synchronized void acquire() {
            while (available <= 0) {
                // wait...
            }
            available = available - 1;
        }

        public synchronized void release() {
            available = available + 1;
        }
    }
    
    /**
     * Make the waiting thread inactive, good for CPU utilization
     */
    class Semaphore2 {
        private int available;
        
        public Semaphore2(int available) {
            this.available = available;
        }
        
        public synchronized void acquire() throws InterruptedException {
            while (available <= 0) {
                wait();
            }
            available = available - 1;
        }
        
        public synchronized void release() {
            available = available + 1;
            notify();
        }
    }
}