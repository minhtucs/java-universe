package juniverse.core.java8.streams;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class SortMap {
    
    static final Map<Integer,Employee> employeeMap = new HashMap<>();
    static {
        employeeMap.put(2, new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1)));
        employeeMap.put(0, new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)));
        employeeMap.put(3, new Employee(3, 40, LocalDate.of(2015, Month.APRIL, 1)));
        employeeMap.put(1, new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)));
    }
    
    public static void main(String[] args) {
//        sortMapByKey();
//        sortMapByValueUseLamda();
//        sortMapByValueUseFunction();
        practice();
    }
    
    static void practice() {
        Map<Integer, Employee> sortedMap = employeeMap.entrySet().stream()
            .sorted((e1, e2) -> e1.getKey() - e2.getKey())
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), 
                (ok, nk) -> ok, LinkedHashMap::new));
    }
    
    /**
     * Explain.
     * 
     * Function<Map.Entry<Integer,Employee>,Integer> keyMapper = e -> e.getKey();
     * Function<Map.Entry<Integer,Employee>,Employee> valueMapper = e -> e.getValue();
     * BinaryOperator<Employee> mergeFunc = (oldValue, newValue) -> oldValue; // resolve duplicated keys
     * Supplier<Map> mapSupplier = LinkedHashMap::new;
     * 
     */
    static void sortMapByKey() {
        Map<Integer,Employee> sortedMap = employeeMap.entrySet().stream()
            .sorted((e1, e2) -> e1.getKey() - e2.getKey())
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (o,n) -> o, LinkedHashMap::new));
        
        System.err.println(sortedMap);
    }
    
    static void sortMapByKey2() {
        Map<Integer,Employee> sortedMap = employeeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (o,n) -> o, LinkedHashMap::new));
        
        System.err.println(sortedMap);
    }

    // sort employee map by salary decreasingly
    static void sortMapByValueUseLamda() {
        Map<Integer, Employee> sorted = employeeMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().getSalary() - e1.getValue().getSalary())
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (o,n) -> o, LinkedHashMap::new));
        
        System.err.println(sorted);
    }
    
    static void sortMapByValueUseFunction() {
        Map<Integer, Employee> sorted = employeeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary).reversed()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n) -> o, LinkedHashMap::new));
        
        System.err.println(sorted);
    }
}
