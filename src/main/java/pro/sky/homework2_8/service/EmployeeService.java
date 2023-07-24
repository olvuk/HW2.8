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

    private final List<Employee> employeesList = new ArrayList<>();
    private final static int maxSize = 3;

    public Employee add(String firstName, String lastName) {

        if (employeesList.size() >= maxSize) {
            throw new EmployeeStorageIsFullException("Сотрудник не может быть добавлен, так как нет свободного места");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employeesList.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть в базе");
        }
        employeesList.add(newEmployee);
        return newEmployee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee EmployeeToRemove = new Employee(firstName, lastName);
        boolean removeResult = employeesList.remove(EmployeeToRemove);
        if (removeResult) {
            return EmployeeToRemove;
        }
        else throw new EmployeeNotFoundException("Сотрудник не удален,так как не найден");
    }

    public Employee find(String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
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
