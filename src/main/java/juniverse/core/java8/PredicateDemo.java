package juniverse.core.java8;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate<T> represents a predicate (~ condition ~ boolean-valued function) of one argument.
 * It's functional interface is: boolean Predicate<T>.test(T t)
 * 
 * @author tunm2
 */
public class PredicateDemo {

    static Collection<Employee> employees = Arrays.asList(
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1))
    );
    
    static void practice() {
        Predicate<Employee> highSalaryPredicate = (e) -> e.salary > 20;
        employees.stream().filter(highSalaryPredicate)
            .forEach(System.out::println);
    }
    
    // filter employees has salary greater than 10
    static void predicateUseLamda() {
        List<Employee> filtered = employees.stream()
            .filter(e -> e.salary > 10)
            .collect(Collectors.toList());
        
        System.err.println(filtered);
    }
    
    // filter employees has salary greater than 10
    static void predicateUseFunction() {
        List<Employee> filtered = employees.stream()
            .filter(Conditions::salaryGt10)
            .collect(Collectors.toList());
        
        System.err.println(filtered);
    }
    
    // filter employees has salary greater than 10 and dob after 2005
    static void combineMultiplePredicates() {
        Predicate<Employee> pSalaryGt10 = e -> e.salary > 10;
        Predicate<Employee> pDobAfter2005 = e -> e.dob.isAfter(LocalDate.of(2005, Month.JANUARY, 1));
        Predicate<Employee> predicate = pSalaryGt10.and(pDobAfter2005);
        
        List<Employee> filtered = employees.stream()
            .filter(predicate)
            .collect(Collectors.toList());
        
        System.err.println(filtered);
    }
}

class Conditions {
    public static boolean salaryGt10(Employee e) {
        return e.salary > 10;
    }
}


