package greatlirik.training.service;

import greatlirik.training.dto.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    void delete(long id);

    Employee getById(long id);

}
