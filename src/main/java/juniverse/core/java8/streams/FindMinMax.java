package juniverse.core.java8.streams;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tunm2
 */
public class FindMinMax {
    
    static List<Employee> employees = Arrays.asList(
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(3, 40, LocalDate.of(2011, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1))
    );
    
    public static void main(String[] args) {
//        findMinSalaryUseLamda();
        findMaxSalaryUseLamda();
    }
    
    static void findMaxSalaryUseLamda() {
        Employee max = employees.stream().max((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
        System.err.println(max);
    }
    
    static void findMinSalaryUseLamda() {
        Employee min = employees.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
        System.err.println(min);
    }
    
    static void findMinSalaryUseFunction() {
        Employee minSalary = employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.err.println(minSalary);
    }
}
