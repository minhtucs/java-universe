package juniverse.core.concurrency.signal;

/**
 * The mechanic behind Lock/Semaphore...
 *
 * @author tunm2
 */
public class ThreadSignaling {

    /**
     * A thread signaling mechanic using volatile variable and infinite loop. 
     * This approach is not good for CPU utilization due to the waiting thread is active
     */
    class BusyWaitSignaling {

        private volatile boolean signalled = false;

        public void doWait() {
            while (!signalled) {
            }
        }

        public void doNotify() {
            signalled = true;
        }
    }

    /**
     * Two problems: 
     *  1 Missed signal (http://tutorials.jenkov.com/java-concurrency/thread-signaling.html)
     *  2 Spurious wakeup (http://tutorials.jenkov.com/java-concurrency/thread-signaling.html)
     */
    static class WaitNotifySignaling1 {

        public void doWait() throws InterruptedException {
            synchronized (this) {
                this.wait();
            }
        }

        public void doNotify() {
            synchronized(this) {
                this.notify();
            }
        }
    }

    /**
     * Fix issue missed signal
     * One problem:
     *   Spurious wakeup (http://tutorials.jenkov.com/java-concurrency/thread-signaling.html)
     */
    class WaitNotifySignaling2 {

        private boolean signalled = false;

        public synchronized void doWait() throws InterruptedException {
            if (!signalled) {
                wait();
            }
            signalled = false;
        }

        public synchronized void doNotify() {
            signalled = true;
            notify();
        }
    }

    /**
     * Overcome two issues above
     */
    class WaitNotifySignaling3 {

        private boolean signalled = false;

        public synchronized void doWait() throws InterruptedException {
            while (!signalled) {
                wait();
            }
            signalled = false;
        }

        public synchronized void doNotify() {
            signalled = true;
            notify();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        WaitNotifySignaling1 signal = new WaitNotifySignaling1();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread 1 waiting...");
                    signal.doWait();
                    System.out.println("thread 1 wakeup");
                } catch (InterruptedException ex) {}
            }
        });
        thread1.start();
        
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread 2 waiting...");
                    signal.doWait();
                    System.out.println("thread 2 wakeup");
                } catch (InterruptedException ex) {}
            }
        });
        thread2.start();
        
        Thread.sleep(3000);
        
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                signal.doNotify();
            }
        });
        thread3.start();
    }
}
