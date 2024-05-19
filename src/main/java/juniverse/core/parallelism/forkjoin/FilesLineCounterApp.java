package juniverse.core.parallelism.forkjoin;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author tunm2
 */
public class FilesLineCounterApp {
    
    private static final int NFILES = 10;
    
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(16);
        BlockingQueue<Object> queue;
    }
}
