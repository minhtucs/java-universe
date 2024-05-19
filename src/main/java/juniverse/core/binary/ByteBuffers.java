package juniverse.core.binary;

import java.nio.ByteBuffer;

/**
 * @author tunm2
 */
public class ByteBuffers {
    
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024);
        
        directBuffer.putInt(1111);
        
        int aInt = buffer.getInt();
        System.out.println(aInt);
    }
    
}
