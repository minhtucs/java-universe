package juniverse.core.java8.streams;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author tunm2
 */
public class StreamOfNumbersDemo {
    
    public static void main(String[] args) {
        intStream();
    }
    
    static void intStream() {
        IntStream.range(0, 20).boxed()
            .sorted((x, y) -> y - x)
            .forEach(System.out::println);
        
        IntStream.range(0, 10).average().ifPresent(System.out::println);
    }
    
    static void aggregate() {
        IntStream iStream = IntStream.range(0, 20);
        int sum = iStream.sum();
        long count = iStream.count();
        int max = iStream.max().orElseThrow(() -> new NoSuchElementException());
        double average = iStream.average().orElse(0);
        
        Stream.iterate(0, i -> i + 1)
            .limit(10)
            .mapToInt(Integer::intValue)
            .average()
            .ifPresent(System.out::println);
    }
    
}
