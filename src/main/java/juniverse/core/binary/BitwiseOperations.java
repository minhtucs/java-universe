package juniverse.core.binary;

/**
 * @author tunm2
 */
public class BitwiseOperations {
    
    static int VALUE = 0x1234; // 0b0001001000110100
    
    public static void main(String[] args) {
        int n = 0b01001101000000001010101000000000;
        int rotated = leftRotate(n, 2);
        System.err.println(Integer.toBinaryString(rotated));
    }
    
    static boolean isEven(int value) {
        return (value & 1) == 0;
    }
    
    static int unsetBit(int value, int k) {
        return value & ~(1 << k);
    }
    
    static int setBit(int value, int k) {
        return value | (1 << k); 
    }
    
    static boolean isSetBit(int value, int k) {
        return (value & (1 << k)) != 0;
    }
    
    // dao nguoc cac bits cua 1 so i32
    static int reverseBits(int value) {
        return value ^ Integer.MAX_VALUE;
    }
    
    // lay k bits cuoi cung cua so i32
    static int getLastKBits(int value, byte k) {
        return (value << (32 - k)) >> (32 - k);
    }
    
    // lay k bits dau tien cua so i32
    static int getFirstKBits(int value, byte k) {
        return value >> (32 - k);
    }
    
    static int leftRotate(int value, int nBits) {
        return (value << nBits) | (value >> (32 - nBits));
    }
    
    static int rightRotate(int value, int nBits) {
        return (value >> nBits) | (value << (32 - nBits));
    }
}