package greatlirik.training.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Employee {


    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private Gender gender;
    private String jobTitle;
    private Date date;
}
