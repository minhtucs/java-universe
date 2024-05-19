package juniverse.common.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class FileUploadClient {
    
    private static final String REQUEST_URL = "http://localhost:8080/fileupload-server/upload";
    private static final String FILE_UPLOADED = "c:\\tmp\\users500K";
    
    private static final int CONNECT_TIMEOUT = 5 * 1000;
    private static final int CONNECTION_REQUEST_TIMEOUT = 5 * 1000;
    private static final int SOCKET_TIMEOUT = 5 * 1000;
    
    private static final int UPLOAD_CHUNK_SIZE = 512 * 1024;
    
    private HttpClient httpClient;
    private HttpRequestBase httpRequest;
    
    private FileUploadClient() {
        RequestConfig.Builder confBuilder = RequestConfig.custom();
        confBuilder.setConnectTimeout(CONNECT_TIMEOUT);
        confBuilder.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
        confBuilder.setSocketTimeout(SOCKET_TIMEOUT);
        RequestConfig reqConf = confBuilder.build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(reqConf).build();
    }
    
    public static void main(String[] args) throws IOException {
        FileUploadClient client = new FileUploadClient();
        
        File file = new File(FILE_UPLOADED);
        String fileName = file.getName();

        byte[] fileData = FileUtils.readFileToByteArray(file);
        int totalSize = fileData.length;
        int totalChunk = totalSize / UPLOAD_CHUNK_SIZE;
        if (totalSize % UPLOAD_CHUNK_SIZE > 0) {
            totalChunk++;
        }
        
        for (int i = 0; i < totalChunk; i++) {
            int fromPos = i * UPLOAD_CHUNK_SIZE;
            int toPos = fromPos + UPLOAD_CHUNK_SIZE;
            if (toPos > totalSize) {
                toPos = totalSize;
            }
            byte[] chunk = Arrays.copyOfRange(fileData, fromPos, toPos);
            Map<String, byte[]> chunks = new HashMap<>();
            chunks.put("chunkContent", chunk);
            HttpEntity httpEntity = buildHttpEntity(chunks, fileName);
            
            String response = client.makePostRequest(REQUEST_URL, httpEntity);
            System.out.println(response);
        }
    }
    
    protected String makeRequest(HttpRequestBase request) throws IOException {
        String strResponse = null;
        BufferedReader buffer = null;
                
        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            InputStream inStream = entity.getContent();
            InputStreamReader reader = new InputStreamReader(inStream);
            buffer = new BufferedReader(reader, 8);
            StringBuilder sb = new StringBuilder();
            
            String line;
            while ((line = buffer.readLine()) != null) {
                sb.append(line).append("\n");
            }

            strResponse = sb.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (buffer != null) {
                buffer.close();
            }
        }

        return strResponse;
    }
    
    public String makePostRequest(String requestUrl, HttpEntity httpEntity) throws IOException {
        httpRequest = new HttpPost(requestUrl);
        ((HttpPost) httpRequest).setEntity(httpEntity);
        
        return makeRequest(httpRequest);
    }
    
    protected static HttpEntity buildHttpEntity(Map<String, byte[]> binaryData, String fileName) {
        if (binaryData == null) {
            return null;
        }
        
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        for (Map.Entry<String, byte[]> chunkEntry : binaryData.entrySet()) {
            byte[] chunk = chunkEntry.getValue();
            builder.addBinaryBody(chunkEntry.getKey(), chunk, ContentType.DEFAULT_BINARY, fileName);
        }

        return builder.build();
    }
}
