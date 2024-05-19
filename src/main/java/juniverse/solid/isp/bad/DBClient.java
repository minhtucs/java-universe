package juniverse.solid.isp.bad;

/**
 * 
 * 
 * @author Tu Nguyen
 */
public interface DBClient {

    Object read(Object key);
    
    boolean write(Object key, Object value);
    
}
