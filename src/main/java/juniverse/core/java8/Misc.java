package juniverse.core.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author tunm2
 */
public class Misc {
    
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(0, x -> x + 1).limit(10);
        String str = stream.map(String::valueOf).collect(Collectors.joining(";"));
        System.err.println(str);
    }
    
}
