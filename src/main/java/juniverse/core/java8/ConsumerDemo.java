package juniverse.core.java8;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * Consumer<T> represents an operation that accept one argument and return nothing.
 * It's functional interface is: void Consumer<T>.accept(t)
 * 
 * @author tunm2
 */
public class ConsumerDemo {
    
    static Collection<Employee> employees = Arrays.asList(
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1))
    );
    
    public static void main(String[] args) {
//        consumeUseLamda();
//        consumeUseFunction();
//        pinelineMultiConsumers();
        practice();
        Integer salarySum = employees.stream()
            .map(Employee::getSalary)
            .reduce(Integer::sum)
            .orElse(0);
        System.err.println(salarySum);
    }
    
    static void practice() {
//        employees.forEach(e -> System.out.println(e));
        employees.forEach(System.out::println);
        employees.forEach(Employee::print);
    }
    
    static void consumeUseLamda() {
        employees.stream().forEach(e -> {
            System.out.println(e);
        });
    }
    
    static void consumeUseFunction() {
        employees.stream().forEach(Operation::print);
    }
    
    static void pinelineMultiConsumers() {
        Consumer<Employee> increaseSalary = e -> e.salary += 1;
        Consumer<Employee> print = System.out::println;
        Consumer<Employee> consumer = increaseSalary.andThen(print);
        
        employees.stream().forEach(consumer);
    }
    
}

class Operation {
    public static void print(Employee e) {
        System.out.println(e);
    }
    public static void increaseSalary(Employee e) {
        e.salary += 1;
    }
}