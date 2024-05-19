package juniverse.common.pool;

import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 *
 * @author tunm2
 */
public class ThreadFactory extends BasePoolableObjectFactory<Thread> {

	@Override
	public Thread makeObject() throws Exception {
		return new Thread();
	}

    @Override
    public boolean validateObject(Thread obj) {
        return true;
    }

    
}
