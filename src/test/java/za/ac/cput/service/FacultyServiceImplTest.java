package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/***
 * Faculty.java
 * Entity for the FacultyServiceImplTest
 * @author Mbuso Kotobe (218040385)
 * Date: 14 August 2022
 */
@SpringBootTest
public class FacultyServiceImplTest {
    private Faculty faculty = null;

    @Autowired
    private IFacultyService service;

    @BeforeEach
    void setUp()
    {
        faculty = FacultyFactory.build("Computer Science", "Information technology");
    }

    @Order(1)
    @Test
    void save()
    {
        Faculty result = null;

        result = service.save(faculty);

        assertNotNull(result);
        assertEquals(faculty, result);
    }

    @Order(2)
    @Test
    void read()
    {
        Optional<Faculty> result = null;

        result = service.read(faculty.getFacultyId());

        assertTrue(result.isPresent());
        assertEquals(faculty, result.get());
    }

    @Order(3)
    @Test
    void findAll()
    {
        List<Faculty> faculties = null;

        faculties = service.findAll();

        assertTrue(faculties.size() > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {

    }
    
    @Order(5)
    @Test
    void delete()
    {
        Optional<Faculty> result = null;

        service.delete(faculty);

        result = service.read(faculty.getFacultyId());
        assertFalse(result.isPresent());

    }
}
