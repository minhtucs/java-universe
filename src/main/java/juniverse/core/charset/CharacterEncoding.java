package juniverse.core.charset;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author tunm2
 */
public class CharacterEncoding {
    public static void main(String[] args) {
        String text = "Nguyễn Minh Tú";
        
        byte[] bytesUTF8 = text.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytesUTF8));
        
        byte[] bytesUTF16 = text.getBytes(StandardCharsets.UTF_16);
        System.out.println(Arrays.toString(bytesUTF16));
        
        byte[] bytesASCII = text.getBytes(StandardCharsets.US_ASCII);
        System.out.println(Arrays.toString(bytesASCII));
    }
}