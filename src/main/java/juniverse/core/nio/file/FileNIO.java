package juniverse.core.nio.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNIO {
    
    public static void main(String[] args) {
        
    }
    
    static void copyFile(String src, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        
        FileChannel fic = fis.getChannel();
        FileChannel foc = fos.getChannel();
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            int len = fic.read(buffer);
            if (len == -1) {
                break;
            }
            
            foc.write(buffer);
        }
        
        fis.close();
        fos.close();
    }
 
    static byte[] read(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        
        fis.close();
        return buffer.array();
    }
    
    static void write(String file, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        channel.write(buffer);
        
        fos.close();
    }
}
