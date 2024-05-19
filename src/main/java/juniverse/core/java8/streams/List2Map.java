package juniverse.core.java8.streams;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class List2Map {

    static Collection<Employee> employees = Arrays.asList(
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1)),
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 2))
    );
    
    public static void main(String[] args) {
//        listToMapUseLamda();
//        functionUseFunction();
          listToMapUseFunctionSolveDuplicateKey();
    }

    // convert list to map
    static void listToMapUseLamda() {
        Map<Integer, Employee> map = employees.stream()
            .collect(Collectors.toMap(e -> e.getId(), e -> e));
        System.err.println(map);
    }
    
    // convert list to map
    static void listToMapUseFunction() {
        Map<Integer, Employee> map = employees.stream()
            .collect(Collectors.toMap(Mapper::buildKey, Mapper::buildValue));
        System.err.println(map);
    }
    
    // convert list to map
    static void listToMapUseFunctionSolveDuplicateKey() {
        Map<Integer, Employee> map = employees.stream()
            .collect(Collectors.toMap(e -> e.getId(), e -> e, (oldKey, newKey) -> oldKey));
        System.err.println(map);
    }
    
}

class Mapper {
    static int buildKey(Employee e) {
        return e.getId();
    }
    
    static Employee buildValue(Employee e) {
        return e;
    }
}