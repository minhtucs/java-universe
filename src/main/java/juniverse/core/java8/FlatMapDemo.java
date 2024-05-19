package juniverse.core.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 *
 * @author tunm2
 */
public class FlatMapDemo {

    static class Profile {
        List<Integer> tags;
        public Profile(List<Integer> tags) { this.tags = tags; }
        
        public List<Integer> getTags() { return this.tags; }
    }
    
    static List<Profile> profiles = Arrays.asList(
        new Profile(Arrays.asList(1, 2)),
        new Profile(Arrays.asList(2, 3))
    );
    
    public static void main(String[] args) {
        flatMapStreamOfIntArrays();
        flatMapStreamOfIntegerArrays();
    }
    
    // why stream of array of primitive ints requires flatMapToInt
    static void flatMapStreamOfIntArrays() {
        Stream<int[]> arrStream = Stream.of(new int[]{1, 2, 3}, new int[]{5, 7});
        arrStream.flatMapToInt(Arrays::stream).boxed().forEach(System.out::println);
    }
    
    static void flatMapStreamOfIntegerArrays() {
        Stream<Integer[]> stream = Stream.of(new Integer[]{1, 2, 3}, new Integer[]{5, 7});
        stream.flatMap(Arrays::stream).forEach(System.out::println);
        stream.flatMap(arr -> Arrays.stream(arr)).forEach(System.out::println);
    }
    
    static void flatMapStreamOfCollections() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2,3), Arrays.asList(5,7));
        stream.flatMap(Collection::stream).forEach(System.out::println);
    }
    
    static Map<Integer, AtomicInteger> statsUsersPerTag(List<Profile> profiles) {
        Map<Integer, AtomicInteger> counter = new HashMap<>();
        profiles.stream()
            .map(Profile::getTags)
            .flatMap(Collection::stream)
            .forEach(t -> counter.computeIfAbsent(t, _t -> new AtomicInteger(0)).incrementAndGet());
        return counter;
    }
    
}
