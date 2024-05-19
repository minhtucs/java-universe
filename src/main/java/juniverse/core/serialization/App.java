package juniverse.core.serialization;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    private static final String OBJECT_FILE_NAME = "C:\\temps\\object.ser"; 
    
    public static void main(String[] args) {
        SerializableObject objToWrite = new SerializableObject(1, "hello");
        writeObject(objToWrite, OBJECT_FILE_NAME);
        SerializableObject objRead = (SerializableObject) readObject(OBJECT_FILE_NAME);
        System.out.println(objRead);
    }
    
    public static void writeObject(Object obj, String fileName) {
        ObjectOutputStream oos = null;
        
        try {
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception ex) {}
            }
        }
    }
    
    public static Object readObject(String fileName) {
        ObjectInputStream ois = null;
        SerializableObject obj = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            obj = (SerializableObject) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception ex) {}
            }
        }
        
        return obj;
    }

}
