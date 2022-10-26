package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.ac.cput.entity.Faculty;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LecturerControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private LecturerController controller;
    private Lecturer lecturer = null;

    private String baseUrl;
    @Autowired
    private TestRestTemplate restTemplate;

    public static String ADMIN_SECURITY_USERNAME = "lecturer-admin";
    public static String ADMIN_SECURITY_PASSWORD = "5678";
    public static String USER_SECURITY_USERNAME = "faculty-user";
    public static String USER_SECURITY_PASSWORD = "1234";

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        //this.lecturer = LecturerFactory.createLecturer(1,"Kruben","", "Naidoo");
        this.lecturer = LecturerFactory.createLecturer(2,"Radford","Wayne", "Burger");
        this.baseUrl = "http://localhost:" + port + "/college-management-system/lecturer/";
    }

    @Order(1)
    @Test
    void save(){
        String url = baseUrl.concat("save/");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Lecturer> entity = new HttpEntity<Lecturer>(lecturer, headers);
        ResponseEntity<Lecturer> response = null;
        response = restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, Lecturer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void read(){
        long lecturerId = 1;
        String url = baseUrl.concat("read/") + lecturerId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Lecturer> response = null;
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Lecturer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Order(3)
    @Test
    void findAll(){
        String url = baseUrl.concat("find-all/");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Lecturer[]> response = null;
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Lecturer[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }
    @Order(4)
    @Test
    void deleteById()
    {
        long lecturerId = 1;
        String url = baseUrl.concat("delete-by-id/") + lecturerId;
        String readUrl = baseUrl.concat("read/") + lecturerId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Lecturer> response = null;

        restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD).exchange(url, HttpMethod.DELETE, null, String.class);
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(readUrl, HttpMethod.GET, entity, Lecturer.class);
        System.out.println(response);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Order(5)
    @Test
    void delete(){

        String url = baseUrl.concat("delete/");
        String readUrl = baseUrl.concat("read/") + lecturer.getLecturerId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Lecturer> response = null;

        restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD).delete(url, lecturer, Lecturer.class);
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(readUrl, HttpMethod.GET, entity, Lecturer.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}