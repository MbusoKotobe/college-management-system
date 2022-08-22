package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;
import static org.junit.jupiter.api.Assertions.*;


/***
 * FacultyControllerTest.java
 * TestCase for the Faculty Controller
 * @author Mbuso Kotobe (218040385)
 * Date: 21 August 2022
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FacultyControllerTest {

    private Faculty faculty = null;
    private String baseUrl;

    @Autowired
    private FacultyController facultyController;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp()
    {
        faculty = FacultyFactory.build(1, "Computer Science", "Information");
        baseUrl = "http://localhost:" + portNumber + "/" + "college-management-system/faculty/";
    }

    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl.concat("save");
        ResponseEntity<Faculty> response = null;

        response = restTemplate.postForEntity(url, faculty, Faculty.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void read()
    {
        int facultyId = 1;
        String url = baseUrl.concat("read/") + facultyId;
        ResponseEntity<Faculty> response = null;

        response = restTemplate.getForEntity(url, Faculty.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Order(3)
    @Test
    void findAll()
    {
        String url = baseUrl.concat("find-all");
        ResponseEntity<Faculty[]> response = null;

        response = restTemplate.getForEntity(url, Faculty[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {
        int facultyId = 1;
        String url = baseUrl.concat("delete-by-id/") + facultyId;

        restTemplate.delete(url);
    }

    @Order(5)
    @Test
    @Disabled
    void delete()
    {
        String url = baseUrl.concat("delete");

        restTemplate.delete(url, faculty, Faculty.class);
    }
}
