package juniverse.common.pool;

/**
 *
 * @author tunm2
 */
public class ThreadPoolDemo {
    
    static final int POOL_SIZE = 2;
    static ThreadPool pool = new ThreadPool(POOL_SIZE);
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = pool.borrowObject();
        Thread thread2 = pool.borrowObject();
        
        pool.returnObject(thread1);
        pool.returnObject(thread2);
		
		System.out.println(pool.toString());
	}
	
}
