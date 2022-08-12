package za.ac.cput.factory;

import za.ac.cput.repository.entity.Department;

public class DepartmentFactory
{
    public static Department createDepartment(String departmentName, String departmentDescription)
    {
        return new Department.Builder().setDepartmentName(departmentName)
                                       .setDepartmentDescription(departmentDescription)
                                       .build();
    }
}