package juniverse.advance.storage;

/**
 *
 * @author tunm2
 */
public interface Serializer {
    
    public byte[] serialize(Object value);
    
    public <T> T deserialize(byte[] bytes);
}
