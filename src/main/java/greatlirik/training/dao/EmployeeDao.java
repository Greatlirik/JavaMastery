package greatlirik.training.dao;

import greatlirik.training.dto.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee getById(Long id);
    void save (Employee employee);
    void delete (Long id);
    void update (Employee employee);
}
