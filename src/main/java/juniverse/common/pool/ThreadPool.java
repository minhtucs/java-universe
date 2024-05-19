package juniverse.common.pool;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

/**
 *
 * @author tunm2
 */
public class ThreadPool extends GenericObjectPool<Thread> {
	
    /** max waiting time before throw exception if cannot borrow object */
    private static final long MAX_WAIT = 1000L;
    
    private static PoolableObjectFactory factory = new ThreadFactory();
    private static Logger logger = Logger.getLogger(ThreadPool.class);
    
	public ThreadPool(int poolSize) {
		super(factory, poolSize, (byte)1, MAX_WAIT);
	}
	
    @Override
	public Thread borrowObject() {
		try {
			return super.borrowObject();
		} catch (Exception ex) {
			logger.error("Error borrowObject", ex);
            return null;
		}
	}
	
    @Override
	public void returnObject(Thread object) {
		try {
			super.returnObject(object);
		} catch (Exception ex) {
			logger.error("Error returnObject", ex);
		}
	}
}
