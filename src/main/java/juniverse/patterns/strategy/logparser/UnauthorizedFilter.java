package juniverse.patterns.strategy.logparser;

/**
 *
 * @author Tu Nguyen
 */
public class UnauthorizedFilter extends FilterStrategy {

    @Override
    public boolean filter(String log) {
        int statusCode = getStatusCode(log);
        return statusCode == 401;
    }
    
}