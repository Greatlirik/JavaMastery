package greatlirik.training.controller;

import greatlirik.training.dto.EmployeeDto;
import greatlirik.training.model.Employee;
import greatlirik.training.model.Gender;
import greatlirik.training.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {


    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeController controller;

    //@BeforeAll
    public void setUp() {
        Employee employeeKirill = new Employee(
                214L, "Kirill", "Zhuk", 2L, Gender.MALE, "tester", LocalDate.now());
        Mockito.when(employeeRepository.findById(employeeKirill.getEmployeeId())).thenReturn(java.util.Optional.of(employeeKirill));
    }


//    @Test
//    void getAllEmployees() {
//        controller.getAllEmployees();
//        Mockito.verify(employeeRepository).findAll();
//    }

    @Test
    void getEmployee() {
        long id = 214L;
        controller.getEmployee(id);
        Mockito.verify(employeeRepository).findById(id);

    }

    @Test
    void saveEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        controller.saveEmployee(employeeDto);
        Mockito.verify(employeeRepository).save(employeeDto.toEmployee());
    }

    @Test
    void deleteEmployee() {
        long id = 214L;
        controller.deleteEmployee(id);
        Mockito.verify(employeeRepository).deleteById(id);
    }

    @Test
    void getEmployeeByFirstNameAndLastName() {
        String firstName = "ki";
        String lastName = "zh";
        controller.getEmployeeByFirstNameAndLastName(firstName, lastName);
        Mockito.verify(employeeRepository).findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
    }
}