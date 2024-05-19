package juniverse.core.binary;

import java.nio.ByteBuffer;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;

public class BinaryUtils {
    
    public static byte[] toBytes(short i16) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) ((i16 >> 8) & 0xFF);
        bytes[1] = (byte) (i16 & 0xFF);
        return bytes;
    }
    
    public static byte[] toBytes(int i32) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((i32 >> 24) & 0xFF);
        bytes[1] = (byte) ((i32 >> 16) & 0xFF);
        bytes[2] = (byte) ((i32 >> 8) & 0xFF);
        bytes[3] = (byte) (i32 & 0xFF);
        return bytes;
    }
    
    public static byte[] toBytes(long i64) {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) ((i64 >> 56) & 0xFF);
        bytes[1] = (byte) ((i64 >> 48) & 0xFF);
        bytes[2] = (byte) ((i64 >> 40) & 0xFF);
        bytes[3] = (byte) ((i64 >> 32) & 0xFF);
        bytes[4] = (byte) ((i64 >> 24) & 0xFF);
        bytes[5] = (byte) ((i64 >> 16) & 0xFF);
        bytes[6] = (byte) ((i64 >> 8) & 0xFF);
        bytes[7] = (byte) (i64 & 0xFF);
        return bytes;
    }
    
    public static byte[] toBytes(String str) {
        try {
            return str.getBytes();
        } catch (UnsupportedCharsetException uce) {
            return null;
        }
    }
    
    public static byte[] toBytes(float fl) {
        return null;
    }
    
    public static byte[] toBytes(boolean bool) {
        byte[] bytes = new byte[1];
        bytes[0] = (byte) (bool ? 0x01 : 0x00);
        return bytes;
    }
    
    public static void main(String[] args) {
        int i32 = 0x000000F1;
        byte[] bytes = new byte[4];
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(i32);
        buffer.get(bytes);
        
        System.out.println(Arrays.toString(bytes));
    }
}
