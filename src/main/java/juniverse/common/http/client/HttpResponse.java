package juniverse.common.http.client;

import juniverse.core.util.JSONUtil;

/**
 * @author tunm2
 */
public class HttpResponse {
    
    public static final HttpResponse ERR_UNKNOWN = new HttpResponse(-1);
    public static final HttpResponse ERR_CONNECTION_TIMEOUT = new HttpResponse(-2);
    public static final HttpResponse ERR_SOCKET_TIMEOUT = new HttpResponse(-3);
    
    private int status;
    private String reason;
    private String body;
    
    public HttpResponse() {}
    
    public HttpResponse(int status) {
        this.status = status;
    }
    
    public HttpResponse(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return JSONUtil.toJSONString(this);
    }
}
