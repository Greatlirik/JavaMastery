package greatlirik.training.model;


import greatlirik.training.validator.BirthDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employeeIdSeq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeIdSeq")
    @Column(name = "id")
    private Long employeeId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate date;

}
