package juniverse.core.concurrency.threadpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolExecutor {
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private Set<Worker> workers = new HashSet<>();

    // limit size of workers set
    private int poolSize;

    public MyThreadPoolExecutor(int nThreads) {
        poolSize = nThreads;
    }

    public void execute(Runnable task) {
        if (workers.size() < poolSize) {
            Worker newWorker = new Worker(task);
            workers.add(newWorker);
            newWorker.start();
        } else {
            tasks.add(task);
        }
    }

    public Runnable getTask() {
        return tasks.poll();
    }

    private class Worker extends Thread {
        Runnable task = null;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = getTask()) != null) {
                task.run();
            }
        }
    }
}
