package juniverse.core.io.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author tunm2
 */
public class FileStreams {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // read single byte only
        FileInputStream fis = new FileInputStream("/tmp/text.txt");
        byte b = (byte) fis.read();
        
        // read single character
        FileReader fileReader = new FileReader("");
        char ch = (char) fileReader.read();
        
        // read line
        BufferedReader buf = new BufferedReader(fileReader);
        String line = buf.readLine();
        
        BufferedWriter buffer = null;
        PrintWriter printer = null;
        
        buffer.flush();
        printer.flush();
    }
    
}
