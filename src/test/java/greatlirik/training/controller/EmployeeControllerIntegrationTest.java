package greatlirik.training.controller;

import greatlirik.training.JavaMasteryApplication;
import greatlirik.training.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaMasteryApplication.class)
@SpringBootTest
class EmployeeControllerIntegrationTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    void getAllEmployees() {
        final ResponseEntity<List<Employee>> responseEntity = testRestTemplate.exchange("http://localhost:8080/api/v1/employees", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(11));
        List<String> jobListList = actualList.stream().map(Employee::getJobTitle).collect(Collectors.toList());
        assertThat(jobListList, containsInAnyOrder("writer", "singer", "scientist", "developer", "tester", "tester", "tester", "tester", "tester", "tester", "tester"));
        assertThat(jobListList, hasItem("writer"));
    }

}