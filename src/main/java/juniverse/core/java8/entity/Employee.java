package juniverse.core.java8.entity;

import java.time.LocalDate;

/**
 *
 * @author tunm2
 */
public class Employee {
    public int id;
    public String name;
    public String gender; // "male","female"
    public int salary;
    public LocalDate dob;
    
    public Employee() {}
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, int salary, LocalDate dob) {
        this.id = id;
        this.salary = salary;
        this.dob = dob;
    }

    public Employee(int id, String gender, int salary, LocalDate dob) {
        this.id = id;
        this.gender = gender;
        this.salary = salary;
        this.dob = dob;
    }

    public Employee id(final int value) {
        this.id = value;
        return this;
    }

    public Employee name(final String value) {
        this.name = value;
        return this;
    }

    public Employee gender(final String value) {
        this.gender = value;
        return this;
    }

    public Employee salary(final int value) {
        this.salary = value;
        return this;
    }

    public Employee dob(final LocalDate value) {
        this.dob = value;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void increaseSalary() {
        this.salary += 1;
    }
    
    public void print() {
        System.out.println(this);
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", dob=" + dob + '}';
    }
    
}
