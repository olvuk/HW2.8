package pro.sky.homework2_8.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import pro.sky.homework2_8.Employee;
import pro.sky.homework2_8.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return e.getStatusCode() + e.getMessage();
    }
    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam Integer department) {
        return employeeService.add(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam Integer department) {
        return employeeService.remove(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam Integer department) {
        return employeeService.find(firstName, lastName, salary, department);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
