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
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
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