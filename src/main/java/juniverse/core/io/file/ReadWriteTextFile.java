package juniverse.core.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ReadWriteTextFile {
    
    private static final String INPUT_FILE_PATH = "c:\\temps\\users.txt";
    private static final String OUTPUT_FILE_PATH = "c:\\temps\\usersOut.txt";
    
    static File inFile = new File(INPUT_FILE_PATH);
    static File outFile = new File(OUTPUT_FILE_PATH);
    static BufferedReader bufReader = null;
    static BufferedWriter bufWriter = null;
    
    public static void main(String[] args) {
//        generateFileForTest(INPUT_FILE_PATH, 5000000);
        
        long start = System.currentTimeMillis();
        readAndWrite2();
        long end = System.currentTimeMillis();
        System.out.println("#### Duration: " + (end - start));
    }
    
    public static void readAndWrite1() {
        
        try {
            InputStream is = new FileInputStream(inFile);
            InputStreamReader reader = new InputStreamReader(is);
            bufReader = new BufferedReader(reader);
            
            OutputStream os = new FileOutputStream(outFile);
            OutputStreamWriter writer = new OutputStreamWriter(os);
            bufWriter = new BufferedWriter(writer);
            
            String line;
            while ((line = bufReader.readLine()) != null) {
                bufWriter.write(line + "\n");
//                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufReader != null) {
                    bufReader.close();
                }
                if (bufWriter != null) { 
                    bufWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void readAndWrite2() {
        File inFile = new File(INPUT_FILE_PATH);
        File outFile = new File(OUTPUT_FILE_PATH);
        BufferedReader bufReader = null;
        BufferedWriter bufWriter = null;
        
        try {
            FileReader reader = new FileReader(inFile);
            bufReader = new BufferedReader(reader);
            
            FileWriter writer = new FileWriter(outFile);
            bufWriter = new BufferedWriter(writer);
            
            String line;
            while ((line = bufReader.readLine()) != null) {
                bufWriter.write(line + "\n");
//                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufReader != null) {
                    bufReader.close();
                }
                if (bufWriter != null) { 
                    bufWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void generateFileForTest(String path, int lines) {
        File outFile = new File(path);
        BufferedWriter bufWriter = null;
        
        try {
            FileWriter writer = new FileWriter(outFile);
            bufWriter = new BufferedWriter(writer);
            
            for (int i = 0; i < lines; i++) {
                bufWriter.write(i + "\n");
//                System.out.println(i);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufWriter != null) { 
                    bufWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
