package juniverse.core.util;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtil {

    private static ObjectMapper mapper = new ObjectMapper();
    private static Logger logger = Logger.getLogger(JSONUtil.class);

    public static String toJSONString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException ex) {
            logger.error("Failed toJSONString " + obj, ex);
            return null;
        }
    }

    public static <T> T fromJSONString(String jsString, Class<T> clazz) {
        try {
            return mapper.readValue(jsString, clazz);
        } catch (IOException ex) {
            logger.error("Failed fromJSONString " + jsString, ex);
            return null;
        }
    }
    
    public static byte[] serialize(Object obj) throws IOException {
        if (obj == null)
            return null;
        
        return mapper.writeValueAsBytes(obj);
    }
    
    public static <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException {
        if (bytes == null)
            return null;
        
        return mapper.readValue(bytes, clazz);
    }
}
