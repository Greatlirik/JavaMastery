package greatlirik.training.controller;


import greatlirik.training.dto.EmployeeDto;
import greatlirik.training.model.Employee;
import greatlirik.training.repository.EmployeeRepository;
import greatlirik.training.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "EmployeeController", description = "allows perform CRUD operations on employee")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    final private EmployeeRepository employeeRepository;
    final private EmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return employees;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}")
    public Employee getEmployee(@PathVariable("id") Long employeeId) {
        return employeeService.findById(employeeId);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto.toEmployee());
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId, @Valid @RequestBody EmployeeDto employeeDto) {
        final Employee employee = employeeService.update(employeeDto.toEmployee(), employeeId);
        return employee;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/query")
    public Employee getEmployeeByFirstNameAndLastName(@RequestParam("firstName") String firstName,
                                                      @RequestParam("lastName") String lastName) {
        return employeeService.findAllByFirstNameAndLastName(firstName, lastName);
    }

}



