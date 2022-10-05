package za.ac.cput.factory;

import za.ac.cput.entity.Department;
/***
 * DepartmentFactory.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */
public class DepartmentFactory
{
    public static Department build(int departmentId, String departmentName, String departmentDescription)
    {
        return new Department.Builder().setDeparmentId(departmentId)
                                       .setDepartmentName(departmentName)
                                       .setDepartmentDescription(departmentDescription)
                                       .build();
    }
}