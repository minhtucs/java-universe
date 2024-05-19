package juniverse.common.pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 *
 * @author tunm2
 */
public class ThriftClientFactory extends BasePooledObjectFactory<ThriftClient> {

    @Override
    public ThriftClient create() throws Exception {
        return new ThriftClient();
    }

    @Override
    public PooledObject<ThriftClient> wrap(ThriftClient client) {
        return new DefaultPooledObject<>(client);
    }

    @Override
    public void passivateObject(PooledObject<ThriftClient> p) throws Exception {
        super.passivateObject(p);
    }
    
}
