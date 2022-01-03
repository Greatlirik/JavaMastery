package greatlirik.training.controller;

import greatlirik.training.dto.Employee;
import greatlirik.training.dto.Gender;
import greatlirik.training.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.util.Date;


@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {



    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    EmployeeController controller;

    @BeforeTestExecution
    public void setUp(){
        Employee employeeKirill = new Employee(
                214L,"Kirill","Zhuk",2L, Gender.MALE,"tester", new Date());
        Mockito.when(employeeService.getById(employeeKirill.getEmployeeId())).thenReturn(employeeKirill);

    }


    @Test
    void getAllEmployees() {
        controller.getAllEmployees();
        Mockito.verify(employeeService).findAll();
    }

    @Test
    void getEmployee() {
        long id = 214L;
        controller.getEmployee(id);
        Mockito.verify(employeeService).getById(id);

    }

    @Test
    void saveEmployee() {
        long id = 214L;
        controller.saveEmployee(employeeService.getById(id));
        Mockito.verify(employeeService).save(employeeService.getById(id));

    }

    @Test
    void updateEmployee() {
        long id = 214L;
        controller.updateEmployee(employeeService.getById(id));
        Mockito.verify(employeeService).update(employeeService.getById(id));
    }

}