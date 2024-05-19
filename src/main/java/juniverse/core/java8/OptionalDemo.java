package juniverse.core.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemo {

    public static void main(String[] args) {
        ofNullableList();
    }

    private static void ofNullableList() {
        List<Integer> list = null;
        HashMap<Integer, Integer> map = Optional.ofNullable(list)
            .orElse(Collections.emptyList())
            .stream()
            .collect(Collectors.toMap(e -> e, e -> e, (o, n) -> n, HashMap::new));
        System.err.println(map);
    }
    
    

    static Optional<String> getResource(int rand) {
        if (rand % 2 == 0) {
            return Optional.of(String.valueOf(rand));
        } else {
            return Optional.ofNullable(null);
        }
    }

    static Optional<List<String>> getResources(int rand) {
        if (rand % 2 == 0) {
            return Optional.of(Arrays.asList(String.valueOf(rand)));
        } else {
            return Optional.ofNullable(null);
        }
    }
}
