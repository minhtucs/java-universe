package juniverse.core.io.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author tunm2
 */
public class ObjectStreams {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream is = null;
        ObjectInputStream ois = new ObjectInputStream(is);
        int id = ois.readInt();
        String name = ois.readUTF();
        Object role = ois.readObject();
    }
    
}
