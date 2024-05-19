package juniverse.common.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author tunm2
 */
public class ApacheHttpClient {
    
    private HttpClient client = HttpClients.createDefault();
    private static Logger logger = Logger.getLogger(ApacheHttpClient.class);
    
    public HttpResponse get(String url) throws URISyntaxException, IOException {
        logger.info("URL: " + url);
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        logger.info("STATUS: " + response.getStatusLine());
        return response;
    }
    
    public HttpResponse get(String url, Map<String, Object> parameters) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (parameters != null && !parameters.isEmpty()) {
            for (Map.Entry<String, Object> param : parameters.entrySet())
                uriBuilder.addParameter(param.getKey(), String.valueOf(param.getValue()));
        }
        URI uri = uriBuilder.build();
        logger.info("URL: " + uri);
        HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        return response;
    }
    
    public HttpResponse get(String url, Map<String, Object> headers, Map<String, Object> parameters) throws URISyntaxException, IOException {
        // build url
        URIBuilder uriBuilder = new URIBuilder(url);
        if (parameters != null && !parameters.isEmpty()) {
            for (Map.Entry<String, Object> param : parameters.entrySet())
                uriBuilder.addParameter(param.getKey(), String.valueOf(param.getValue()));
        }
        HttpGet request = new HttpGet(uriBuilder.build());
        // add headers
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, Object> header : headers.entrySet()) {
                request.addHeader(header.getKey(), String.valueOf(header.getValue()));
            }
        }
        
        HttpResponse response = client.execute(request);
        return response;
    }
    
    /**
     * Post UrlEncoded
     * ectype = application/x-www-form-urlencoded
     */
    public HttpResponse post(String url, Map<String, Object> parameters) throws URISyntaxException, IOException {
        List<NameValuePair> paramPairs = new ArrayList<>();
        for (Map.Entry<String, Object> param : parameters.entrySet())
            paramPairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        request.setEntity(new UrlEncodedFormEntity(paramPairs, StandardCharsets.UTF_8));
        
        HttpResponse response = client.execute(request);
        return response;
    }
    
    public HttpResponse postJSON(String url, Map<String, Object> parameters) throws URISyntaxException, IOException {
        JSONObject json = new JSONObject(parameters);
        StringEntity entity = new StringEntity(json.toString());
        
        HttpPost request = new HttpPost(url);
        request.setEntity(entity);
        request.setHeader("Content-Type", "application/json");
//        request.setHeader("Accept-Encoding", "gzip");
        HttpResponse response = client.execute(request);
        return response;
    }
    
    public HttpResponse postMultipart(String url, Map<String, Object> parameters) throws URISyntaxException, IOException {
        List<NameValuePair> paramPairs = new ArrayList<>();
        for (Map.Entry<String, Object> param : parameters.entrySet())
            paramPairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        
        HttpPost request = new HttpPost(url);
        request.setEntity(new UrlEncodedFormEntity(paramPairs));
        
        HttpResponse response = client.execute(request);
        return response;
    }
}
