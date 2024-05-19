package juniverse.core.binary;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author tunm2
 */
public class BinPresentation {
    
    static byte[] utf8 = {
//        1100010
        (byte)0x11000001, (byte)0x10100010
    };
    
    public static void main(String[] args) {
        byte b = (byte)0b11000011;
        byte h = (byte)0xC3;
        System.err.println(b == h);
        System.err.println(Short.MAX_VALUE);
//        encodeChar();
//        int x = 0x00000080;
//        System.out.println(0x7f);
//        System.out.println(x);
//        byte[] utf8 = new byte[] { (byte)0b11000000, 0b1000000 };
//        System.out.println(0x07ff - 0x0080 + 1);
//        System.out.println(Math.pow(2, 12) - 1);
//        System.out.println(0x00E2 - 0x0080);
//        System.out.println(Integer.toBinaryString(98));
//        encodeChar();
//        representBin();
        // 11111
//        System.out.println(Integer.toBinaryString(0x1F600));
//        byte[] utf8 = new byte[] {
//            (byte)0x11110000, (byte)0x10011111, (byte)0x10011000, (byte)0x10000000
//        };
//        System.out.println(new String(utf8, StandardCharsets.UTF_8));
//        char ch = '合';
//        String s = "😀";
//        char[] toCharArray = s.toCharArray();
//        System.out.println(Arrays.toString(toCharArray));
//        byte[] bytesUTF8 = s.getBytes(StandardCharsets.UTF_8);
//        System.out.println("bytesUTF8: " + Arrays.toString(bytesUTF8));
//        byte[] bytesUTF16 = s.getBytes(StandardCharsets.UTF_16);
//        System.out.println("bytesUTF16: " + Arrays.toString(bytesUTF16));
//        
//        System.out.println(new String(bytesUTF16, StandardCharsets.UTF_16));
    }
    
    static void representBin() {
        int signedINum = -4;
        int unsignedINum = 4;
        byte bnum = (byte)0b10011111;
        System.out.println(bnum);
        System.out.println(Integer.toBinaryString(bnum & 0xFF));
//        System.err.println(Integer.toBinaryString(bnum & 0xFF));
//        System.err.println("unsigned: " + Integer.toBinaryString(unsignedINum));
//        System.err.println("signed: " + Integer.toBinaryString(signedINum & 0xFF));
    }
    
    static void encodeChar() {
//        String s = "満充電する場合";
//        String s = "😀😍";
        String s = "â";
        char ch = s.charAt(0);
        System.out.println((int)ch);
//        String s = "満";
        String enojiS = "⛔️";
        char[] toCharArray = enojiS.toCharArray();
        System.out.println("⛔️: " + Arrays.toString(toCharArray));
        
        byte[] utf8 = s.getBytes(StandardCharsets.UTF_8);
        byte[] utf16 = s.getBytes(StandardCharsets.UTF_16);
        
        int codePoint = Character.codePointAt(s, 0);
        System.err.println("++ unicode: " + codePoint);
        System.err.println("++ utf-8: " + Arrays.toString(utf8));
        for (byte b : utf8) {
            System.err.print(Integer.toBinaryString(b & 0xFF));
            System.err.print(" ");
        }
        System.err.println();
        System.err.println("++ utf-16: " + Arrays.toString(utf16));
        
        int hex = 0x6E80;
        byte hex2 = (byte)0xE6;
        System.err.println("hex2: " + hex2);
        System.err.println(hex);
        
    }
    
    static void unicodeToUTF8(int codePoint) {
        
    }
}