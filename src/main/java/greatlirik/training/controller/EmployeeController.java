package greatlirik.training.controller;


import greatlirik.training.model.Employee;
import greatlirik.training.model.dto.EmployeeDto;
import greatlirik.training.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    final private EmployeeRepository employeeRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId) {
        return ResponseEntity.of(this.employeeRepository.findById(employeeId));
    }


    @PostMapping(value = "")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

        final Employee employee = employeeRepository.save(employeeDto.toEmployee());

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long employeeId) {
        Employee employee = employeeRepository.getOne(employeeId);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employeeRepository.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,@Valid @RequestBody EmployeeDto employeeDto) {
        Employee checkEmployee = employeeRepository.getOne(employeeId);
        if (checkEmployee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final Employee employee = this.employeeRepository.save(employeeDto.toEmployee());

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @GetMapping(value = "/query")
    public ResponseEntity<Employee> getEmployeeByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return ResponseEntity.of(this.employeeRepository.findByFirstNameAndLastNameIgnoreCase(firstName, lastName));
    }

}



