package greatlirik.training.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    @Id
    private Long employeeId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Long departmentId;

    @NotBlank
    private Gender gender;

    @NotBlank
    private String jobTitle;

    @NotBlank
    private Date date;
}
