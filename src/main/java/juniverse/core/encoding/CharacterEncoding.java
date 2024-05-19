package juniverse.core.encoding;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * <link>http://www.joelonsoftware.com/articles/Unicode.html</link>
 * 
 * @author tunm2
 */
public class CharacterEncoding {
    
    static String strEn = "abc";
    static String strVi = "test thôi mà";
    static String ch3bytes = "⿁";
    
    public static void main(String[] args) {
        System.out.println("DEFAULT CHARSET: " + Charset.defaultCharset());
        
        byte[] encodeUTF8 = encodeISO88591(ch3bytes);
        System.out.println(decodeISO88591(encodeUTF8));
//        BigInteger bi = new BigInteger(encodeUTF8);
//        System.out.println(bi.toString(2));
//        printInBinary(encodeUTF8);
//        System.out.println(encodeUTF8.length);
        String base64 = Base64.getEncoder().encodeToString("hello 90xladf89`a]d".getBytes());
        System.err.println(base64);
    }
    
    // 7bits for each character
    static byte[] encodeASCII(String string) {
        return string.getBytes(StandardCharsets.US_ASCII);
    }
    
    static String decodeASCII(byte[] asciiBytes) {
        return new String(asciiBytes, StandardCharsets.US_ASCII);
    }
    
    static byte[] encodeISO88591(String string) {
        return string.getBytes(StandardCharsets.ISO_8859_1);
    }
    
    static String decodeISO88591(byte[] iso8859Bytes) {
        return new String(iso8859Bytes, StandardCharsets.ISO_8859_1);
    }

    // variable length encoding, 1-4bytes for each character
    static byte[] encodeUTF8(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }
    
    static String decodeUTF8(byte[] utf8bytes) {
        return new String(utf8bytes, StandardCharsets.UTF_8);
    }

    // 2bytes for each character and 2bytes for presenting BYTE ORDER
    static byte[] encodeUTF16(String string) {
        return string.getBytes(StandardCharsets.UTF_16);
    }
    
    static String decodeUTF16(byte[] utf16bytes) {
        return new String(utf16bytes, StandardCharsets.UTF_16);
    }
    
    // 2bytes for each character, BIG ENDIAN BYTE ORDER
    static byte[] encodeUTF16BE(String string) {
        return string.getBytes(StandardCharsets.UTF_16BE);
    }
    
    static String decodeUTF16LE(byte[] utf16BEbytes) {
        return new String(utf16BEbytes, StandardCharsets.UTF_16BE);
    }
    
    // 2bytes for each character, LITTLE ENDIAN BIT ORDER
    static byte[] encodeUTF16LE(String string) {
        return string.getBytes(StandardCharsets.UTF_16LE);
    }
    
    static String decodeUTF16BE(byte[] utf16LEbytes) {
        return new String(utf16LEbytes, StandardCharsets.UTF_16LE);
    }
    
    static void printInBinary(byte[] bytes) {
        int nbytes = bytes.length;
        for (int i = 0; i < nbytes; i++) {
            System.out.print(Integer.toBinaryString(bytes[i]));
            System.out.print(i < nbytes-1 ? " " : "\n");
        }
    }
}
