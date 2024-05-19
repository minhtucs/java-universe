package juniverse.core.java8.streams;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class SortList {
    
    static List<Employee> employees = Arrays.asList(
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1))
    );
    
    public static void main(String[] args) {
//       sortListWithOriginalModified();
        sortListWithoutModifyUseFunction();
    }
    
    static void sortListWithOriginalModified() {
        Comparator<Employee> comparator = (e1, e2) -> e1.salary - e2.salary;
        Collections.sort(employees, comparator);
        System.err.println(employees);
    }
    
    static void sortListWithoutModifyUseLamda() {
        List<Employee> sorted = employees.stream()
            .sorted((e1, e2) -> e1.salary - e2.salary)
            .collect(Collectors.toList());
        System.err.println(sorted);
    }
    
    static void sortListWithoutModifyUseFunction() {
        List<Employee> sorted = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .collect(Collectors.toList());
        System.err.println(sorted);
    }
    
}

