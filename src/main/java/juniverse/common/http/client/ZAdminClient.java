package juniverse.common.http.client;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tunm2
 */
public class ZAdminClient {
    
    static String DOMAIN = "http://127.0.0.1:9040";
    static String SESSION = "cd8324975c8a9225997680475d400c56c0b06ee08e2660b26759dd62ed416fdc";
    
    static NativeHttpClient httpClient = new NativeHttpClient();
    
    public static void main(String[] args) throws Exception {
//        login();
        getResources();
    }
    
    static void login() throws UnsupportedEncodingException {
        Map<String, Object> params = new HashMap<>();
        params.put("username", 84983418851L);
        params.put("password", "password");
        
        HttpResponse response = httpClient.post(DOMAIN, "/auth/login", params, null);
        System.err.println("++RESPONSE: " + response);
    }
    
    static void getResources() throws UnsupportedEncodingException {
        Map<String, Object> headers = new HashMap<>();
        headers.put("auth", SESSION);
        
        Map<String, Object> params = new HashMap<>();
        params.put("username", 84983418851L);
        params.put("password", "password");
        
        HttpResponse response = httpClient.get(DOMAIN, "/resources", params, headers);
        System.err.println("++RESPONSE: " + response);
    }
}
