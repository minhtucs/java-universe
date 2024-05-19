package juniverse.core.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tunm2
 */
public class ThreadPools {
    
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 5, 0, 
            TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
    
    static ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
    
    static ExecutorService executor = Executors.newFixedThreadPool(10);    
    
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 5, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
        
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + ": " + System.currentTimeMillis());
            }
        });
    }
}
