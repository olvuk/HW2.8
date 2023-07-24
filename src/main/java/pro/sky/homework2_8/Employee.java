package pro.sky.homework2_8;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final double salary;
    private final int department;


    public Employee(String firstName, String lastName, double salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

    public String toString() {
        return "Имя: " + firstName + " Фамилия " + lastName + " Зарплата: " + salary + " Отдел: " + department;
    }
}
