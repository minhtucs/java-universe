package juniverse.core.concurrency.signal;

/**
 *
 * @author tunm2
 */
public class ThreadSignaling2 {
    
    static class ThreadSignaler {
        
        volatile boolean signaled = false;
        
        void doWait() throws InterruptedException {
            System.err.println("Waiting...");
            if (!signaled) {
                synchronized (this) {
                    this.wait();
                }
            }
            signaled = false;
            System.err.println("Done waiting");
        }
        
        void doNotify() {
            signaled = true;
            synchronized (this) {
                this.notify();
            }
            System.err.println("Notified");
        }
    }
    
    public static void main(String[] args) {
        ThreadSignaler signaler = new ThreadSignaler();
        
        new Thread(() -> {
            signaler.doNotify();
        }).start();
        
        new Thread(() -> {
            try {
                signaler.doWait();
            } catch (InterruptedException ex) {
            }
        }).start();
    }
}
