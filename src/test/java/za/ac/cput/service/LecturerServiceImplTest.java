package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LecturerServiceImplTest {

    private final Lecturer lecturer = LecturerFactory
            .createLecturer(1,"Kruben", "Naidoo");

    @Autowired
    private ILecturerService service;

    @Order(1)
    @Test
    void save(){
        Lecturer newLecturer = this.service.save(this.lecturer);
        assertEquals(this.lecturer, newLecturer);
        System.out.println(newLecturer);
    }

    @Order(2)
    @Test
    void read(){
        Optional<Lecturer> read = this.service.read(this.lecturer.getLecturerId());
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.lecturer,read.get())
        );
    }

    @Order(3)
    @Test
    void findAll(){
        List<Lecturer> employeeList = this.service.findAll();
        assertEquals(1,employeeList.size());
    }

    @Order(4)
    @Test
    void delete(){
        this.service.deleteById(this.lecturer.getLecturerId());
        List<Lecturer> lecturers = this.service.findAll();
        assertEquals(0,lecturers.size());
    }
}