package juniverse.common.http.client;

import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author tunm2
 */
public class HttpsClient {
    
    public static void main(String[] args) throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] { new DefaultTrustManager() };

        URL url = new URL("https://https-demo.vn/");
        SSLContext sslcontext = SSLContext.getInstance("SSL");
        sslcontext.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.connect();
        
        System.out.println("RESPONSE: " + connection.getResponseCode());
    }
    
    private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
        
        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
        
        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}