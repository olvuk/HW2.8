package pro.sky.homework2_8.service;

import org.springframework.stereotype.Service;
import pro.sky.homework2_8.Employee;
import pro.sky.homework2_8.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee getEmployeeWithMaxSalary (Integer department) {

       return employeeService.getAll().stream()
               .filter(employee -> employee.getDepartment() == department)
               .max(Comparator.comparing(Employee::getSalary))
               .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с максимальной зарплатой не найден"));
    }

    public Employee getEmployeeWithMinSalary (Integer department) {

        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник с минимальной зарплатой не найден"));
    }

    public List<Employee> getAllEmployeesInDepartment (Integer department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employeeService.getAll().stream()
                .collect(groupingBy(Employee::getDepartment, toList()));
    }
}
