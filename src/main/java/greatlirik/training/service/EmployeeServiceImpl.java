package greatlirik.training.service;

import greatlirik.training.dao.EmployeeDao;
import greatlirik.training.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    public EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(long id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee getById(long id) {
        return employeeDao.getById(id);
    }
}
