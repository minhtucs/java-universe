package juniverse.advance.storage;

import java.nio.ByteBuffer;

/**
 *
 * @author tunm2
 */
public class Meta {
    
    public static final int SIZE = 4;
    
    public int offset; // 0 means not exists
    
    public Meta() {}

    public byte[] serialize() {
        ByteBuffer bb = ByteBuffer.allocate(SIZE);
        bb.putInt(offset);
        return bb.array();
    }

    public void deserialize(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        this.offset = bb.getInt();
    }
}
