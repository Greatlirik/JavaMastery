package greatlirik.training.controller;


import greatlirik.training.exception.ResourceNotFoundException;
import greatlirik.training.model.Employee;
import greatlirik.training.dto.EmployeeDto;
import greatlirik.training.repository.EmployeeRepository;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}")
    public Employee getEmployee(@PathVariable("id") Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found employee with id " + employeeId));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeRepository.save(employeeDto.toEmployee());
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId, @Valid @RequestBody EmployeeDto employeeDto) {
        employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("not found employee with id " + employeeId));
        final Employee employee = employeeDto.toEmployee();
        employee.setEmployeeId(employeeId);
        employeeRepository.save(employee);
        return employee;

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/query")
    public Employee getEmployeeByFirstNameAndLastName(@RequestParam("firstName") String firstName,
                                                      @RequestParam("lastName") String lastName) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName)
                .orElseThrow(() -> new ResourceNotFoundException("not found employee with this parameters"));
    }

}



