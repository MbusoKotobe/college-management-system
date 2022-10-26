package za.ac.cput.factory;

import za.ac.cput.entity.Department;
import za.ac.cput.entity.Faculty;

/***
 * DepartmentFactory.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */
public class DepartmentFactory
{
    public static Department build(int departmentId, String departmentName, String departmentDescription, Faculty faculty)
    {
        return Department.builder().departmentId(departmentId)
                                   .departmentName(departmentName)
                                   .departmentDescription(departmentDescription)
                                   .faculty(faculty)
                                   .build();
    }
}