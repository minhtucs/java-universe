package juniverse.patterns.strategy.logparser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Tu Nguyen
 */
public class App {
    
    public static void main(String[] args) {
        LogParser parser = new LogParser();
        
        // parse success logs
        parser.setFilter(new SuccessFilter());
        List<String> logsParsed = parser.parse(prepareLogFile());
        System.out.println("Success");
        System.out.println(logsParsed);
        
        // parse unauthorized logs
        parser.setFilter(new UnauthorizedFilter());
        logsParsed = parser.parse(prepareLogFile());
        System.out.println("Unauthorized");
        System.out.println(logsParsed);
    }
    
    static InputStream prepareLogFile() {
        StringBuilder logs = new StringBuilder();
        logs.append("2018-05-10 00:00:00 \"POST /api/message HTTP/1.0\" 200\n");
        logs.append("2018-05-10 00:00:11 \"POST /api/message HTTP/1.0\" 401\n");
        byte[] bytes = logs.toString().getBytes();
        return new ByteArrayInputStream(bytes);
    }
}
