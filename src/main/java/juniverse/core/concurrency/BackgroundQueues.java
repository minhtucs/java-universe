package juniverse.core.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tunm2
 */
public class BackgroundQueues {
    public static final int NWORKERS = 5;
    
    public static ExecutorService executorService = Executors.newFixedThreadPool(NWORKERS);
    public static ScheduledExecutorService scheduleService = Executors.newScheduledThreadPool(NWORKERS);
    
    public static BlockingQueue<Task> blockingQueue = new LinkedBlockingQueue<>();
    public static DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();
    
    public static class Task implements Runnable {
        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public static class DelayedTask implements Delayed {
        @Override
        public long getDelay(TimeUnit unit) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int compareTo(Delayed o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
