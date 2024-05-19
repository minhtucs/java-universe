package juniverse.core.java8.streams;

import java.util.Arrays;

/**
 *
 * @author tunm2
 */
public class ConvertStreamToArray {

    public static void main(String[] args) {
        String[] array = Arrays.asList("hello", "world")
            .stream()
            .toArray(String[]::new);
        System.err.println(Arrays.toString(array));
    }
    
}
