package za.ac.cput.controller;

/*
author: Ameer Ismail
student nr: 218216033
Controller impl testing : Student Controller Test
ADP 3 Assignment Group1
Student Domain Controller Test
*/

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired private StudentController control;
    @Autowired private TestRestTemplate restTemplate;

    private Student student;
    private String url;

    @BeforeEach
    void setUp()
    {
        assertNotNull(control);
        this.student = StudentFactory.createStudent("Ameer", "", "Ismail", 218216033);
        this.url = "http://localhost:" + this.port + "/college-management-system/student/";
    }

    //save
    @Order(1)
    @Test
    void save()
    {
        String Url = url + "save";
        System.out.println(Url);

        ResponseEntity<Student> response = this.restTemplate
                .postForEntity(Url, this.student, Student.class);
        System.out.println(response);

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );
    }

    //reading
    @Order(2)
    @Test
    void read()
    {
        String Url = url + "read/" + this.student.getStudentNumber();
        System.out.println(Url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(Url, Student.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    //find all
    @Order(3)
    @Test
    void findAll()
    {
        String Url = url + "find-all";
        System.out.println(Url);

        ResponseEntity<Student[]> response = this.restTemplate.getForEntity(Url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertEquals(1, response.getBody().length)
                );
    }

    //deleting
    @Order(4)
    @Test
    void delete()
    {
        String Url = url + "delete/" + this.student.getStudentNumber();
        System.out.println(Url);
        this.restTemplate.delete(Url);
    }

}