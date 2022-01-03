import greatlirik.training.dao.EmployeeDao;
import greatlirik.training.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeDao employeeDao;

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Test
    void findAll() {
        employeeServiceImpl.findAll();
        Mockito.verify(employeeDao).findAll();
    }

    @Test
    void getById() {
        long id = 0L;
        employeeServiceImpl.getById(id);
        Mockito.verify(employeeDao).getById(id);
    }

    @Test
    void saveEmployee() {
        long id = 0L;
        employeeServiceImpl.save(employeeDao.getById(id));
        Mockito.verify(employeeDao).save(employeeDao.getById(id));

    }

    @Test
    void updateEmployee() {
        long id = 0L;
        employeeServiceImpl.update(employeeDao.getById(id));
        Mockito.verify(employeeDao).update(employeeDao.getById(id));
    }

    @Test
    void deleteEmployee() {
        long id = 0L;
        employeeServiceImpl.delete(id);
        Mockito.verify(employeeDao).delete(id);
    }

}
