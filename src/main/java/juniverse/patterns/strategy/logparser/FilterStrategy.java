package juniverse.patterns.strategy.logparser;

/**
 *
 * @author Tu Nguyen
 */
public abstract class FilterStrategy {
    
    abstract boolean filter(String log);
    
    protected int getStatusCode(String log) {
        String[] columns = log.split(" ");
        return Integer.parseInt(columns[5]);
    }
    
}
