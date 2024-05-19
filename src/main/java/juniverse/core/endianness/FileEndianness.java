package juniverse.core.endianness;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEndianness {
    
    public static void main(String[] args) {
        try {
            int value = 0x01020304;
            File file = new File("c:\\temps\\text.dat");
            
            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(value);
            
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(value);
            
//            fos.close();
            
            FileInputStream fis = new FileInputStream(file);
            System.out.println(fis.read());
            
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    static byte[] getBytes(int value) {
        byte[] b = new byte[4];
        b[0] = (byte) ((value >> 24) & 0xFF);
        b[1] = (byte) ((value >> 16) & 0xFF);
        b[2] = (byte) ((value >> 8) & 0xFF);
        b[3] = (byte) ((value >> 0) & 0xFF);
        return b;
    }
    
}
