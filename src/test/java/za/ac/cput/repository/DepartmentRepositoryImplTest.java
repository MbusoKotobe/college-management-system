package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryImplTest
{
    private IDepartmentRepository repository = DepartmentRepositoryImpl.getDepartmentRepository();
    private Department department = DepartmentFactory.createDepartment("Information Technology", "Information management");

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
    }

    @Test
    void delete ()
    {
    }
}