package juniverse.patterns.strategy.logparser;

/**
 *
 * @author Tu Nguyen
 */
public class SuccessFilter extends FilterStrategy {

    @Override
    boolean filter(String log) {
        int statusCode = getStatusCode(log);
        return statusCode == 200;
    }

}
