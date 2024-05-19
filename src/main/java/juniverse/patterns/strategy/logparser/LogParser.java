package juniverse.patterns.strategy.logparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Log format.
 * 
 * 2018-05-10 00:00:00 "POST /api/message HTTP/1.0" 200
 * 2018-05-10 00:00:10 "POST /api/message HTTP/1.0" 200
 * 
 * @author Tu Nguyen
 */
public class LogParser {
    
    FilterStrategy filter;

    public void setFilter(FilterStrategy filter) {
        this.filter = filter;
    }
    
    public List<String> parse(InputStream logInput) {
        List<String> logs = new ArrayList<>();
        
        try (
            InputStreamReader reader = new InputStreamReader(logInput);
            BufferedReader buffer = new BufferedReader(reader);
            ) {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (filter.filter(line)) {
                    logs.add(line);
                }
            }
        } catch (IOException ex) {
        }
        
        return logs;
    }
}
