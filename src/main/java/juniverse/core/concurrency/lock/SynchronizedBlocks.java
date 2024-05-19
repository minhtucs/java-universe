package juniverse.core.concurrency.lock;

/**
 *
 * @author tunm2
 */
public class SynchronizedBlocks {
    
    static final SynchronizedBlocks inst1 = new SynchronizedBlocks();
    static final SynchronizedBlocks inst2 = new SynchronizedBlocks();
    
    public static void main(String[] args) throws Exception {
        testSync2MethodsOfSameInstance();
    }
    
    static void testSync2MethodsOfSameInstance() {
        new Thread(() -> {
            try {
                inst1.syncInstance1();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        
        new Thread(() -> {
            try {
                inst1.syncInstance2();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
    
    synchronized void syncInstance1() throws InterruptedException {
        System.out.println("Start syncInstance1");
        Thread.sleep(5000);
        System.out.println("Finish syncInstance1");
    }
    
    synchronized void syncInstance2() throws InterruptedException {
        System.out.println("Start syncInstance2");
        Thread.sleep(5000);
        System.out.println("Finish syncInstance2");
    }
    
    static synchronized void syncClass() throws InterruptedException {
        System.out.println("Start syncClass");
        Thread.sleep(5000);
        System.out.println("Finish syncClass");
    }
    
}
