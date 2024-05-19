package juniverse.core.io.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author tunm2
 */
public class BasicStreams {

    public static void main(String[] args) throws IOException {
        InputStream is = null;
        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        char ch  = (char) reader.read();
    }
    
}
