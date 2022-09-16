/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 
 */
package za.ac.cput.factory;

import za.ac.cput.repository.entity.StudentDepartment;



public class StudentDepartmentFactory {
    public static StudentDepartment createStudentDepartment(long studentNumber, int departmentId){
       StudentDepartment studentDepartment = new StudentDepartment.Builder().setStudentNumber(studentNumber)
                .setDepartmentId(departmentId)
                .build();
        return studentDepartment;

    }
}
