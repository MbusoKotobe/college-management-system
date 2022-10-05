package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LecturerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private LecturerController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Lecturer lecturer;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.lecturer = LecturerFactory.createLecturer(1,"Kruben","Naidoo");
        this.baseUrl = "http://localhost:" + port + "/college-management-system/lecturer/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Lecturer> response = this.restTemplate
                .postForEntity(url, this.lecturer, Lecturer.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read(){
        String url = baseUrl + "read/" + this.lecturer.getLecturerId();
        System.out.println(url);
        ResponseEntity<Lecturer> response = this.restTemplate.getForEntity(url, Lecturer.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Order(3)
    @Test
    void delete(){
        //TODO: Please include a test here to ensure that it works.
        /**
         * I know in class they said that delete doesn't return anything
         * for security reasons. You don't want to let your user know whether
         * the deletion process was successful or not BUT for development purposes
         * it is recommended we test thoroughly and make sure everything works.
         *
         * To Test this, After the Deletion of a record, you could call read(),
         * using the ID of the deleted object and check if the status code returned
         * by read is 404 (NOT FOUND). Check FacultyControllerTest for Reference.
         *
         * OR
         *
         * You could call find-all() and check if the size of the returned records
         * matches what you expect which is 0 because you just deleted the only
         * record that existed in the database.
         * */
        String url = baseUrl + "delete/" + this.lecturer.getLecturerId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(4)
    @Test
    void findAll(){
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Lecturer[]> response =
                this.restTemplate.getForEntity(url, Lecturer[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }
}