package pro.sky.homework2_8.service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_8.Employee;
import pro.sky.homework2_8.exception.EmployeeAlreadyAddedException;
import pro.sky.homework2_8.exception.EmployeeNotFoundException;
import pro.sky.homework2_8.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public EmployeeService() {
        employeesList.add(new Employee("Семен", "Васильев", 50000.0, 1));
        employeesList.add(new Employee("Светлана", "Василькова", 52000.0, 1));
        employeesList.add(new Employee("Борис", "Семенов", 56000.0, 2));
        employeesList.add(new Employee("Вера", "Антонова", 60000.0, 2));
        employeesList.add(new Employee("Григорий", "Абрикосов", 51000.0, 2));
        employeesList.add(new Employee("Агния", "Березкина", 46000.0, 3));
        employeesList.add(new Employee("Вячеслав", "Мушкин", 59000.0, 3));
        employeesList.add(new Employee("Станислава", "Сережкина", 43000.0, 4));
        employeesList.add(new Employee("Андрей", "Веревкин", 70000.0, 4));

    }

    private final List<Employee> employeesList = new ArrayList<>();
    private final static int maxSize = 20;

    public Employee add(String firstName, String lastName, double salary, Integer department) {

        if (employeesList.size() >= maxSize) {
            throw new EmployeeStorageIsFullException("Сотрудник не может быть добавлен, так как нет свободного места");
        }
        Employee newEmployee = new Employee(firstName, lastName, salary, department);
        if (employeesList.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в базе");
        }
        employeesList.add(newEmployee);
        return newEmployee;
    }

    public Employee remove(String firstName, String lastName, double salary, Integer department) {
        Employee EmployeeToRemove = new Employee(firstName, lastName, salary, department);
        boolean removeResult = employeesList.remove(EmployeeToRemove);
        if (removeResult) {
            return EmployeeToRemove;
        }
        else throw new EmployeeNotFoundException("Сотрудник не удален,так как не найден");
    }

    public Employee find(String firstName, String lastName, double salary, Integer department) {
        Employee employeeToFind = new Employee(firstName, lastName, salary, department);
        for (Employee e : employeesList) {
            if (e.equals(employeeToFind)) {
                return e;
            }
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    public List<Employee> getAll() {
        return employeesList;
    }
}
