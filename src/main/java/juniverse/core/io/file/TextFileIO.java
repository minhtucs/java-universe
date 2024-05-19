package juniverse.core.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tunm2
 */
public class TextFileIO {
    
    static final int EOF = -1;

    public static void main(String[] args) throws IOException {
        List<String> lines = readLines("/tmp/data.txt");
        System.out.println(lines);
    }
    
    static void copy(String fromFileName, String toFileName) throws IOException {
        File fi = new File(fromFileName);
        FileInputStream fis = new FileInputStream(fi);
        
        File fo = new File(toFileName);
        FileOutputStream fos = new FileOutputStream(fo);
        
        int b;
        while ((b = fis.read()) != EOF) {
            fos.write(b);
        }
        
        fis.close();
        fos.close();
    }
    
    static List<String> readLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        
        File fi = new File(fileName);
        FileInputStream fis = new FileInputStream(fi);
        int b;
        
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        int lineSize = 0;
        byte[] bytes;
        while ((b = fis.read()) != EOF) {
            lineSize++;
            if (b != '\n') {
                buffer.put((byte) b);
            } else {
                bytes = new byte[lineSize];
                buffer.flip();
                buffer.get(bytes, 0, lineSize-1);
                String line = new String(bytes, StandardCharsets.US_ASCII);
                lines.add(line);
                
                lineSize = 0;
                buffer.rewind();
            }
        }
        
        fis.close();
        
        return lines;
    }
}