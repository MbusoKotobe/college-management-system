package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Department;
import za.ac.cput.entity.Faculty;

import static org.junit.jupiter.api.Assertions.*;
/***
 * Department Factory Test.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */
class DepartmentFactoryTest
{
    @Test
    void createDepartment ()
    {
        Faculty faculty = FacultyFactory.build(12,"Informatics and Design", "Information and visual designing");
        Department department = DepartmentFactory.build(11,"Information Technology", "Information management", faculty);
        assertNotNull(department);
    }
}