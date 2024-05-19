package juniverse.common.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

/**
 *
 * @author tunm2
 */
public class TestClient {
    
    public static void main(String[] args) throws Exception {
        testApacheClientGET();
    }
    
    static void testApacheClientGET() throws URISyntaxException, IOException {
        ApacheHttpClient client = new ApacheHttpClient();
        
        Map<String, Object> params = new HashMap<>();
        params.put("msg", "Test thôi mà");
        
        org.apache.http.HttpResponse resp = client.get("http://localhost:8080/ping", params);
        
        HttpEntity entity = resp.getEntity();
        InputStream content = entity.getContent();
        BufferedReader bufreader = new BufferedReader(new InputStreamReader(content));
        String line;
        StringBuilder respBuilder = new StringBuilder();
        while ((line = bufreader.readLine()) != null) {
            respBuilder.append(line);
        }
        System.out.println(respBuilder);
    }
    
    static void testApacheClientPOST() throws URISyntaxException, IOException {
        ApacheHttpClient client = new ApacheHttpClient();
        
        Map<String, Object> params = new HashMap<>();
        params.put("msg", "Test thôi mà");
        
        org.apache.http.HttpResponse resp = client.post("http://localhost:8080/ping", params);
        
        HttpEntity entity = resp.getEntity();
        InputStream content = entity.getContent();
        BufferedReader bufreader = new BufferedReader(new InputStreamReader(content));
        String line;
        StringBuilder respBuilder = new StringBuilder();
        while ((line = bufreader.readLine()) != null) {
            respBuilder.append(line);
        }
        System.out.println(respBuilder);
    }
    
    static void testNativeClient() throws UnsupportedEncodingException {
        NativeHttpClient client = new NativeHttpClient();
        
        Map<String, Object> params = new HashMap<>();
        params.put("msg", "Test thôi mà");
        
        HttpResponse resp = client.post("http://localhost:8080", "/ping", params, null);
        System.out.println(resp);
    }
}
