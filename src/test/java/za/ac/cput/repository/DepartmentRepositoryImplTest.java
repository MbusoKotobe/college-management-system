package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;


class DepartmentRepositoryImplTest {

    private final IDepartmentRepository repository = DepartmentRepositoryImpl.getDepartmentRepository();
    private final Department department = DepartmentFactory.createDepartment("Information Technology", "Information management");

    @Test
    void getAll ()
    {
        System.out.println("Showing all departments");
        System.out.println(repository.getAll());
    }

    @Test
    void create ()
    {
        Department department = DepartmentFactory.createDepartment("Information Technology", "Information management");
        assertEquals(repository.create(department).getDepartmentName(), department.getDepartmentName());
    }

    @Test
    void read ()
    {
        Department department = repository.read(0);
        assertNotNull(department);
    }

    @Test
    void update ()
    {
        repository.create(department);
        Department updatedDepartment = new Department.Builder().copy(department)
                .setDepartmentName("Multimedia Technology")
                .build();
        assertNotNull(repository.update(updatedDepartment));
    }

    @Test
    void delete ()
    {
        boolean operationStatus = repository.delete(department.getDeparmentId());
        assertTrue(operationStatus);
    }

}