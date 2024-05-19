package juniverse.core.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadWriteBinaryFile {
    
    private static final String INPUT_FILE_PATH = "c:\\temps\\Chrysanthemum.jpg";
    private static final String OUTPUT_FILE_PATH = "c:\\temps\\ChrysanthemumOut.jpg";
    
    private static final int BUFF_SIZE = 1014;
    
    static File inFile = new File(INPUT_FILE_PATH);
    static File outFile = new File(OUTPUT_FILE_PATH);
    
    static InputStream is = null;
    static OutputStream os = null;
    
    public static void main(String[] args) {
        
    }
    
    static void basicReadWrite() {
        try {
            byte[] buffer = new byte[BUFF_SIZE];
            is = new FileInputStream(inFile);
            os = new FileOutputStream(outFile);
            
            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) { 
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
