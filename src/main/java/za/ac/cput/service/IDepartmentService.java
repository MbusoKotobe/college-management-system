package za.ac.cput.service;

import za.ac.cput.entity.Department;
/***
 * Department.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */
public interface IDepartmentService extends IService<Department, Integer> {
    void deleteById(Integer departmentId);

}
