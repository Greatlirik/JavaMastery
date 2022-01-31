package greatlirik.training.model.dto;

import greatlirik.training.model.Employee;
import greatlirik.training.model.Gender;
import greatlirik.training.validator.BirthDate;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class EmployeeDto {
    @NotEmpty(message = "The first name is required.")
    private String firstName;

    @NotEmpty(message = "The last name is required.")
    private String lastName;

    @NotNull(message = "The department id  is required.")
    private Long departmentId;

    @NotNull(message = "The gender is required.")
    private Gender gender;

    @NotEmpty(message = "The job Title is required.")
    private String jobTitle;

    @NotNull(message = "The date of birth is required.")
    @BirthDate(message = "The birth date must be greater or equal than 18")
    @Past(message = "The date of birth must be in the past.")
    private LocalDate date;

    public Employee toEmployee() {
        return new Employee()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDepartmentId(departmentId)
                .setGender(gender)
                .setJobTitle(jobTitle)
                .setDate(date);
    }
}
