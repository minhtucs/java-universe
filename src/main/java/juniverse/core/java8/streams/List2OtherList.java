package juniverse.core.java8.streams;

import juniverse.core.java8.entity.Employee;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tunm2
 */
public class List2OtherList {
    
    static Collection<Employee> employees = Arrays.asList(
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 1)),
        new Employee(1, 20, LocalDate.of(2005, Month.APRIL, 1)),
        new Employee(2, 30, LocalDate.of(2010, Month.APRIL, 1)),
        new Employee(0, 10, LocalDate.of(2000, Month.APRIL, 2))
    );
    
    static void getListEmployeeId() {
        List<Integer> ids = employees.stream()
            .map(e -> e.getId())
            .collect(Collectors.toList());
        System.err.println(ids);
    }
    
    static void buildEmployeesResultFromEmployees() {
        List<EmployeeResult> result = employees.stream()
            .map(e -> new EmployeeResult(0, e))
            .collect(Collectors.toList());
        System.err.println(result);
    }
    
}

class EmployeeResult {
    int error;
    Employee employee;

    public EmployeeResult(int error, Employee employee) {
        this.error = error;
        this.employee = employee;
    }
    
}
