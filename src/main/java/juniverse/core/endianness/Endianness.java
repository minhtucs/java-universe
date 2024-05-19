package juniverse.core.endianness;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Given i32 value: 0x0A0B0C0D.
 * 
 * - Bytes in Big-Endian: byte[] bytes = { 0x0A, 0x0B, 0x0C, 0x0D }
 *     bytes[0] = 0x0A
 *     bytes[1] = 0x0B
 *     bytes[2] = 0x0C
 *     bytes[3] = 0x0D
 * 
 * - Bytes in Little-Endian: byte[] bytes = { 0x0D, 0x0C, 0x0B, 0x0A }
 *     bytes[0] = 0x0D
 *     bytes[1] = 0x0C
 *     bytes[2] = 0x0B
 *     bytes[3] = 0x0A
 * 
 * @author tunm2
 */
public class Endianness {
    
    static int xvalue = 0x0A0B0C0D;
    static int bvalue = 0b00001010000010110000110000001101;
    
    public static void main(String[] args) {
        System.out.println(0x0A0B0C0D);
        System.out.println(xvalue == bvalue);
        
        System.out.print("IN BIG ENDIAN ORDER: ");
        byte[] bytesInBE = storeValueAsBigEndian(xvalue);
        for (byte b : bytesInBE) {
            System.out.print(Integer.toBinaryString(b) + ", ");
        }
        System.out.println("");
        
        System.out.print("IN LITTLE ENDIAN ORDER: ");
        byte[] bytesInLE = storeValueAsLittleEndian(xvalue);
        for (byte b : bytesInLE) {
            System.out.print(Integer.toBinaryString(b) + ", ");
        }
        System.out.println("");
    }
    
    static byte[] storeValueAsBigEndian(int value) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(value);
        buffer.flip();
        
        byte[] bytes = new byte[4];
        buffer.get(bytes, 0, 4);
        return bytes;
    }
    
    static byte[] storeValueAsLittleEndian(int value) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(value);
        buffer.flip();
        
        byte[] bytes = new byte[4];
        buffer.get(bytes, 0, 4);
        return bytes;
    }
}
