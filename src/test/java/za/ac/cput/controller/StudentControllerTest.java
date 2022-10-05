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
        String Url = url + "delete/" + this.student.getStudentNumber();
        System.out.println(Url);
        this.restTemplate.delete(Url);
    }

}