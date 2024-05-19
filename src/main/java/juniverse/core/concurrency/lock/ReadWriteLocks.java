package juniverse.core.concurrency.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://en.wikipedia.org/wiki/Readers%E2%80%93writers_problem
 *
 * @author tunm2
 */
public class ReadWriteLocks {
    
    /**
     * Reads blocks writes but doesn't block other reads.
     * Writes blocks reads and other writes.
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    
    // writes block other writes
    // writes lock reads
    // reads doesn't block other reads
    public static void main(String[] args) {
        ReadWriteLocks test = new ReadWriteLocks();
        new Thread(() -> test.write("writer-1")).start(); // this writer blocks next writer
        new Thread(() -> test.write("writer-2")).start(); // this writer blocks next reader
        new Thread(() -> test.read("reader-1")).start();  // this reader doesn't block next reader
        new Thread(() -> test.read("reader-2")).start();  // this reader blocks next writer
        new Thread(() -> test.write("writer-3")).start();
    }
    
    void read(String reader) {
        lock.readLock().lock();
        try {
            System.err.println(String.format("[%s] reading...", reader));
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        } finally {
            System.err.println(String.format("[%s] read done!", reader));
            lock.readLock().unlock();
        }
    }
    
    void write(String writer) {
        lock.writeLock().lock();
        try {
            System.err.println(String.format("[%s] writting...", writer));
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        } finally {
            System.err.println(String.format("[%s] write done!", writer));
            lock.writeLock().unlock();
        }
    }
    
}
