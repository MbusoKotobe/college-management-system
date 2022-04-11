/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 *
 */
package za.ac.cput.repository;

import za.ac.cput.entity.StudentDepartment;

import java.util.Set;

public interface IStudentDepartment extends IRepository<StudentDepartment, Long>{
    public Set<StudentDepartment> getAll();
}
