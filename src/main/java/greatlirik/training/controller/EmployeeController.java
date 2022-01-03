package greatlirik.training.controller;

import greatlirik.training.dto.Employee;
import greatlirik.training.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    final private EmployeeService employeeService;

    @GetMapping(value = "")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId) {

        Employee employee = this.employeeService.getById(employeeId);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employeeService.save(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @PutMapping(value = "")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employeeService.update(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.getById(employeeId);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employeeService.delete(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}



