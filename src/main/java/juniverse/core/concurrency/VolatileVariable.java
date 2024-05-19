package juniverse.core.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tunm2
 */
public class VolatileVariable {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        final Server server = new Server(executor);
        server.serve();
        server.stop();
        
        executor.shutdown();
        System.out.println("Called shutdown!");
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MICROSECONDS);
        System.out.println("Called awaitTermination!");
    }

    static class Server {
        private ExecutorService executor = null;
        private volatile boolean stopped = false;
        
        public Server(ExecutorService executor) {
            this.executor = executor;
        }

        public void serve() {
            System.out.println("Server is serving...");
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    while (!stopped) {
//                        try { Thread.sleep(2*1000); } catch (Exception ex) {}
                    }

                    System.out.println("Server has stopped!");
                }
            };

            this.executor.execute(runner);
        }

        public void stop() throws Exception {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    try { Thread.sleep(10*1000); } catch (Exception ex) {}
                    
                    stopped = true;
                    System.out.println("Stopped the server");
                }
            };

            this.executor.execute(runner);
        }
    }
}
