package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Department;

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
        Department department = DepartmentFactory.build(11,"Information Technology", "Information management");
        assertNotNull(department);
    }
}