package juniverse.common.http.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 * @author tunm2
 */
public class NativeHttpClient {
    
    private int connTimeout = (int) TimeUnit.SECONDS.toMillis(3);
    private int readTimeout = (int) TimeUnit.SECONDS.toMillis(10);
    
    public NativeHttpClient() {}

    public NativeHttpClient(int connTimeout, int readTimeout) {
        this.connTimeout = connTimeout;
        this.readTimeout = readTimeout;
    }
    
    private static Logger logger = Logger.getLogger(NativeHttpClient.class);
    
    private HttpResponse makeRequest(String method, String domain, String uri, String query, Map<String, Object> headers) {
        method = method.toUpperCase();
        boolean writeQueryToBody = method.equals("POST") || method.equals("PUT");
        String reqUrl = buildRequestUrl(domain, uri, writeQueryToBody ? null : query);
        logger.info("REQUEST URL: " + reqUrl);
        
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setConnectTimeout(connTimeout);
            conn.setReadTimeout(readTimeout);
            updateRequestHeader(conn, headers);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.connect();
            
            if (writeQueryToBody) {
                conn.setRequestProperty("Content-Length", query == null ? "0" : String.valueOf(query.length()));
                try (DataOutputStream writer = new DataOutputStream(conn.getOutputStream())) {
                    writer.writeBytes(query);
                    writer.flush();
                }
            }
            
            HttpResponse response = new HttpResponse();
            response.setStatus(conn.getResponseCode());
            response.setBody(parseResponseBody(conn));
            return response;
        } catch (SocketTimeoutException ex) {
            logger.error(ex.getMessage(), ex);
            return HttpResponse.ERR_SOCKET_TIMEOUT;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return HttpResponse.ERR_UNKNOWN;
        }
    }
    
    public HttpResponse get(String domain, String uri, String query, Map<String, Object> headers) {
        return makeRequest("GET", domain, uri, query, headers);
    }
    
    public HttpResponse get(String domain, String uri, String query) {
        return get(domain, uri, query, null);
    }
    
    public HttpResponse get(String domain, String uri, Map<String, Object> params, Map<String, Object> headers) {
        return get(domain, uri, buildRequestQuery(params), headers);
    }
    
    public HttpResponse get(String domain, String uri, Map<String, Object> params) {
        return get(domain, uri, params, null);
    }

    public HttpResponse post(String domain, String uri, String query, Map<String, Object> headers) {
        return makeRequest("POST", domain, uri, query, headers);
    }
    
    public HttpResponse post(String domain, String uri, String query) {
        return post(domain, uri, query, null);
    }
    
    public HttpResponse post(String domain, String uri, Map<String, Object> params, Map<String, Object> headers) {
        return post(domain, uri, buildRequestQuery(params), headers);
    }
    
    public HttpResponse post(String domain, String uri, Map<String, Object> params) {
        return post(domain, uri, params, null);
    }
    
    public HttpResponse put(String domain, String uri, String query, Map<String, Object> headers) {
        return makeRequest("PUT", domain, uri, query, headers);
    }
    
    public HttpResponse put(String domain, String uri, String query) {
        return put(domain, uri, query, null);
    }
    
    public HttpResponse put(String domain, String uri, Map<String, Object> params, Map<String, Object> headers) {
        return put(domain, uri, buildRequestQuery(params), headers);
    }
    
    public HttpResponse put(String domain, String uri, Map<String, Object> params) {
        return put(domain, uri, params, null);
    }
    
    public HttpResponse delete(String domain, String uri, String query) {
        return makeRequest("DELETE", domain, uri, query, null);
    }
    
    public HttpResponse delete(String domain, String uri, Map<String, Object> params) {
        return delete(domain, uri, buildRequestQuery(params));
    }
    
    private String buildRequestQuery(Map<String, Object> params) {
        StringBuilder qbuilder = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            try {
                for (Map.Entry<String, Object> param : params.entrySet()) {
                    String pval = URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8");
                    qbuilder.append(param.getKey()).append("=").append(pval).append("&");
                }
            } catch (UnsupportedEncodingException e) {}
            qbuilder.deleteCharAt(qbuilder.length()-1);
        }
        return qbuilder.toString();
    }
    
    private String buildRequestUrl(String domain, String uri, String query) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(domain);
        
        if (uri != null && !uri.isEmpty())
            urlBuilder.append(uri);
        
        if (query != null && !query.isEmpty())
            urlBuilder.append(urlBuilder.lastIndexOf("?") == -1 ? "?" : "&").append(query);
        
        return urlBuilder.toString();
    }
    
    private void updateRequestHeader(URLConnection conn, Map<String, Object> headers) {
        if (headers == null || headers.isEmpty())
            return;
        
        for (Map.Entry<String, Object> header : headers.entrySet())
            conn.setRequestProperty(header.getKey(), String.valueOf(header.getValue()));
    }
    
    private String parseResponseBody(URLConnection conn) throws IOException {
        StringBuilder content = new StringBuilder();
        InputStream instream = conn.getInputStream(); // stream between client and server
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
        
        String line;
        try {
            while ((line = reader.readLine()) != null)
                content.append(line);
        } finally {
            reader.close();
        }
        
        return content.toString();
    }
}