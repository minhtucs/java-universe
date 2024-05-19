package juniverse.common.pool2;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool2.PooledObjectFactory;

/**
 *
 * @author tunm2
 */
public class ThriftClientPool extends GenericObjectPool<ThriftClient> {
    
    private static PooledObjectFactory factory = new ThriftClientFactory();
    
    public ThriftClientPool() {
//        super(factory);
    }

    public ThriftClientPool(PoolableObjectFactory<ThriftClient> factory) {
        super(factory);
    }
    

    @Override
    public void returnObject(ThriftClient obj) throws Exception {
        super.returnObject(obj);
    }

    @Override
    public ThriftClient borrowObject() throws Exception {
        return super.borrowObject();
    }
    
}
