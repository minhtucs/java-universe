package juniverse.common.http.server;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 *
 * @author tunm2
 */
public class HttpJettyServer {
    
    static final int PORT = 8080;
    static Logger logger = Logger.getLogger(HttpJettyServer.class);
    
    public static void main(String[] args) {
         Server server = new Server(PORT);
        
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(PingServlet.class, "/ping");
        server.setHandler(handler);
        
        try {
            server.start();
            logger.info("Server is running...");
            server.join();
        } catch (Exception ex) {
            logger.error("Cannot start server: ", ex);
        } finally {
            server.destroy();
        }
    }
    
}
