package greatlirik.training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private Gender gender;
    private String jobTitle;
    private Date date;
}
