package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.repository.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest
{
    @Test
    void createDepartment ()
    {
        Department department = DepartmentFactory.createDepartment("Information Technology", "Information management");
        assertNotNull(department);
    }
}