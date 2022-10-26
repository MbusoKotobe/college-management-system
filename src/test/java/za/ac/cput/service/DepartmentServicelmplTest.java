package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/***
 * Department.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentServicelmplTest {
    private Department department = null;

    @Autowired
    private IDepartmentService service;

    @BeforeEach
    void setUp()
    {
        department = DepartmentFactory.build(1,"Computer Science", "Computer Science");
    }

    @Order(1)
    @Test
    void save()
    {
        Department result = null;

        result = service.save(department);

        assertNotNull(result);
        assertEquals(department, result);
    }

    @Order(2)
    @Test
    void read()
    {
        Integer departmentId = 1;
        Optional<Department> result = null;

        result = service.read(departmentId);

        assertTrue(result.isPresent());
        assertEquals(department, result.get());
    }

    @Order(3)
    @Test
    void findAll()
    {
        List<Department> faculties = null;

        faculties = service.findAll();

        assertTrue(faculties.size() > 0);
    }

    @Order(4)
    @Test
    void deleteById()
    {
        Integer departmentId = 1;
        Optional<Department> result = null;

        service.deleteById(departmentId);
        result = service.read(department.getDeparmentId());

        assertFalse(result.isPresent());
    }

    @Order(5)
    @Test
    @Disabled
    void delete()
    {
        Optional<Department> result = null;

        service.delete(department);

        result = service.read(department.getDeparmentId());
        assertFalse(result.isPresent());

    }

}