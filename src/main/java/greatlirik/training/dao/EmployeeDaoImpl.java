package greatlirik.training.dao;

import greatlirik.training.dto.Employee;
import greatlirik.training.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource dataSource;

   @PostConstruct
   private void initialize(){
       setDataSource(dataSource);
   }

    @Override
    public List<Employee> findAll() {
        log.info("IN EmployeeDaoImpl get all");
        String sql = "SELECT * FROM employee";
        return this.getJdbcTemplate().query(sql, new EmployeeMapper());
    }

    @Override
    public Employee getById(Long id) {
        log.info("IN EmployeeDaoImpl getByID {}", id);
        String sql = "SELECT * FROM employee WHERE id=?";
        return this.getJdbcTemplate().queryForObject(sql, new EmployeeMapper(), id);
    }

    @Override
    public void save(Employee employee) {
        log.info("IN EmployeeDaoImpl save {}", employee);
        String sql = "INSERT INTO employee (date_of_birth,department_id,first_name,gender,job_title,last_name) VALUES(?::date,?,?,?,?,?)";
        this.getJdbcTemplate().update(sql, employee.getDate(),
                employee.getDepartmentId(), employee.getFirstName(), employee.getGender().toString(), employee.getJobTitle(), employee.getLastName());
    }

    @Override
    public void delete(Long id) {
        log.info("IN EmployeeDaoImpl delete{}", id);
        String sql = "DELETE FROM employee WHERE id=?";
        this.getJdbcTemplate().update(sql, id);

    }

    @Override
    public void update(Employee employee) {
        log.info("IN EmployeeDaoImpl update {}", employee);
        String sql = "UPDATE employee SET date=?::date, department_id=?, first_name=?, gender=?, job_title=?, last_name=? WHERE id=?";
        this.getJdbcTemplate().update(sql, employee.getDate(), employee.getDepartmentId(), employee.getFirstName(),
                employee.getGender(), employee.getJobTitle(),
                employee.getLastName(), employee.getEmployeeId());

    }
}
