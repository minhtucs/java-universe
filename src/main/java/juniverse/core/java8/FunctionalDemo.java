package juniverse.core.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalDemo {

    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("tu", 27, 35));
        employees.add(new Employee("ranky", 30, 40));
    }

    public static void main(String[] args) {
        java8Demo();
    }

    static void java7Demo() {

    }

    static void java8Demo() {
        List<Employee> filter = filter(employees, salaryGreaterThan35);
        employees.stream()
                .filter(e -> e.salary > 35)
                .forEach(System.out::println);
    }
    
    static Predicate<Employee> salaryGreaterThan35 = e ->  (e.salary > 35);

    static List<Employee> filter(List<Employee> employees, Predicate<Employee> predicate) {
        List<Employee> filtered = new ArrayList<>();
        employees.forEach(e -> {
            if (predicate.test(e)) {
                filtered.add(e);
            }
        });
        return filtered;
    }

    static class Employee {
        String name;
        int age;
        int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + ", age=" + age + ", salary=" + salary + "}";
        }
    }

}
