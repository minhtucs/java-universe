package juniverse.common.http.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author tunm2
 */
public class PingServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(PingServlet.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = req.getParameter("msg");
        logger.info("MESSAGE: " + msg);
        
        JSONObject response = new JSONObject();
        response.put("client_msg", msg);
        response.put("server_msg", "Test thôi mà");
        
        out(req, resp, response.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Content-Type: " + req.getHeader("Content-Type"));
        String msg = req.getParameter("msg");
        logger.info("MESSAGE: " + msg);
        
        JSONObject response = new JSONObject();
        response.put("client_msg", msg);
        response.put("server_msg", "Test thôi mà");
        
        out(req, resp, response.toString());
    }
    
    protected void out(HttpServletRequest req, HttpServletResponse resp, Object content) throws IOException {
//		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=utf-8");
//        resp.addHeader("Content-Type", "application/json; charset=utf-8");
//        resp.setHeader("Content-Type", "application/json; charset=utf-8");
        
		try (PrintWriter out = resp.getWriter()) {
			out.print(content);
		}
	}
    
}
