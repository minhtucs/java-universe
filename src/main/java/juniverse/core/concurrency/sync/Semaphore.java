package juniverse.core.concurrency.sync;

/**
 *
 * @author tunm2
 */
public class Semaphore {
    
    volatile int permits = 0;
    
    public Semaphore(int permits) {
        this.permits = permits;
    }
    
    public void wait(int permits) {
        while (this.permits < permits) {}
        this.permits -= permits;
    }
    
    public void signal(int permits) {
        this.permits += permits;
    }
}