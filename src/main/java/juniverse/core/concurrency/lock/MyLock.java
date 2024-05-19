package juniverse.core.concurrency.lock;

/**
 *
 * @author tunm2
 */
public class MyLock {

    private boolean locked = false;

    public synchronized void lock() throws InterruptedException {
        while (locked)
            wait();
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }
}
