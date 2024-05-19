package juniverse.core.java8;

import java.io.IOException;
import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class MapReduceDemo {
    
    static Collection<Employee> employees = Arrays.asList(
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1)),
        new Employee(3, 20, LocalDate.of(2005, Month.APRIL, 1))
    );
    
    static int sumSalary(Collection<Employee> employees) {
        return employees.stream()
            .map(Employee::getSalary)
            .reduce(Integer::sum).get();
    }
    
    static void groupBy() {
        Map<Integer, List<Employee>> groupBySalary = employees.stream()
            .collect(Collectors.groupingBy(e -> e.salary));
        System.err.println(groupBySalary);
    }
    
    public static void main(String[] args) throws IOException {
        
    }
}
