package juniverse.core.java8.streams;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author tunm2
 */
public class StreamsDemo {
    
    public static void main(String[] args) {
//        streamOf();
//        streamIterate();
//        streamSort();
//        streamReduce();
//        streamConcanateString2();
//        streamBreak();
        Stream.of(1, 2, 3)
            .peek(value -> System.err.println("peek " + value))
            .forEach(value -> System.err.println(value));
    }
    
    static void streamOf() {
        List<String> list = Stream.of("one", "two", "three", "four", "five")
            .peek(e -> System.out.println(e))
            .filter(e -> e.length() > 3)
            .peek(System.out::println)
            .map(String::toUpperCase)
            .peek(System.out::println)
            .collect(Collectors.toList());
        
        System.err.println(list);
    }
    
    static void streamIterate() {
        Stream.iterate(1, i -> i+1)
            .limit(10)
            .forEach(System.out::println);
    }
    
    static void streamSort() {
        Random random = new Random();
        long total = random.ints(100, 0, 200)
            .boxed()
            .sorted((x, y) -> y - x)
            .peek(System.out::println)
            .count();
        System.err.println("count: " + total);
    }
    
    static void streamReduce() {
        Optional<String> reduced = Stream.of("hello", "world", "vn", "hcm")
            .reduce((s1, s2) -> s1 + " - " + s2);
        reduced.ifPresent(System.out::println);
    }
    
    static void streamConcanateString() {
        IntStream.range(1, 20).boxed()
            .map(String::valueOf)
            .reduce((x, y) -> x + ", " + y)
            .ifPresent(System.out::println);
    }
    
    static void streamConcanateString2() {
        StringJoiner joiner = new StringJoiner(", ");
        IntStream.range(1, 20).boxed().map(String::valueOf).forEach(joiner::add);
        System.err.println(joiner);
    }
    
    static void streamBreak() {
        IntStream.range(1, 2000000000)
            .filter(x -> x % 5 == 0)
            .findFirst()
            .ifPresent(System.out::println);
    }
}
