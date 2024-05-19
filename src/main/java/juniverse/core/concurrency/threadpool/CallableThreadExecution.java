package juniverse.core.concurrency.threadpool;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author tunm2
 */
public class CallableThreadExecution {
    
    static final int NTHREADS = 4;
    static ExecutorService executors = Executors.newFixedThreadPool(NTHREADS);
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        test1();
//        test2();
        long duration = (System.currentTimeMillis() - start);
        System.out.println("DURATION: " + duration);
//        System.exit(0);
    }
    
    static void test1() throws InterruptedException, ExecutionException {
        Map<Integer, Future> futures = new HashMap<>(NTHREADS);
        for (int i = 0; i < NTHREADS; i++) {
            Task task = new Task(i);
            Future<Integer> future = executors.submit(task);
            futures.put(i, future);
        }
        
        for (Map.Entry<Integer, Future> entry : futures.entrySet()) {
            Future<Integer> future = entry.getValue();
            Integer result = future.get();
            System.out.println(String.format("[%d] result: %d", entry.getKey(), result));
        }
    }
    
    static void test2() throws InterruptedException, ExecutionException {
        for (int i = 0; i < NTHREADS; i++) {
            Task task = new Task(i);
            Future<Integer> future = executors.submit(task);
            Integer result = future.get();
            System.out.println("result " + i + ": " + result);
        }
    }
    
    static class Task implements Callable<Integer> {
        int id;
        
        public Task(int id) {
            this.id = id;
        }
        
        @Override
        public Integer call() throws Exception {
            System.out.println(String.format("[%d] sleeping", id));
            Thread.sleep(5000);
            System.out.println(String.format("[%d] wake up", id));
            return id;
        }
    }
}
