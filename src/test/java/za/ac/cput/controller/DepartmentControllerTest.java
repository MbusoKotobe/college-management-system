package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.entity.Department;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.factory.FacultyFactory;

import static org.junit.jupiter.api.Assertions.*;
/***
 * Department.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentControllerTest {
    private Department department = null;
    private String baseUrl;

    @Autowired
    private DepartmentController departmentController;

    @LocalServerPort
    private int portNumber;

    @Autowired
    private TestRestTemplate restTemplate;

    public static String ADMIN_SECURITY_USERNAME = "admin";
    public static String ADMIN_SECURITY_PASSWORD = "721087c4-0ede-407e-8c1f-ac57e531f293";
    public static String USER_SECURITY_USERNAME = "user";
    public static String USER_SECURITY_PASSWORD = "721087c4-0ede-407e-8c1f-ac57e531f292";

    @BeforeEach
    void setUp()
    {
        Faculty faculty = FacultyFactory.build(12,"Informatics and Design", "Information and visual designing");
        department = DepartmentFactory.build(6, "Science", "The field of study concerned with discovering and describing the world around us by observing and experimenting.", faculty);
        baseUrl = "http://localhost:" + portNumber + "/" + "college-management-system/faculty/";
    }

    @Order(1)
    @Test
    void save()
    {
        String url = baseUrl.concat("save");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Department> entity = new HttpEntity<Department>(department, headers);
        ResponseEntity<Department> response = null;

        response = restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, Department.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Order(2)
    @Test
    void read()
    {
        int departmentId = 1;
        String url = baseUrl.concat("read/") + departmentId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Department> response = null;

        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Department.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Order(3)
    @Test
    void findAll()
    {
        String url = baseUrl.concat("find-all");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Department[]> response = null;

        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, Department[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {
        int departmentId = 6;
        String url = baseUrl.concat("delete-by-id/") + departmentId;
        String readUrl = baseUrl.concat("read/") + departmentId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Department> response = null;

        restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD).exchange(url, HttpMethod.DELETE, null, String.class);
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(readUrl, HttpMethod.GET, entity, Department.class);
        System.out.println(response);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Order(5)
    @Test
    @Disabled
    void delete()
    {
        String url = baseUrl.concat("delete");
        String readUrl = baseUrl.concat("read/") + department.getDepartmentId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Department> response = null;

        restTemplate.withBasicAuth(ADMIN_SECURITY_USERNAME, ADMIN_SECURITY_PASSWORD).delete(url, department, Department.class);
        response = restTemplate.withBasicAuth(USER_SECURITY_USERNAME, USER_SECURITY_PASSWORD)
                .exchange(readUrl, HttpMethod.GET, entity, Department.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}