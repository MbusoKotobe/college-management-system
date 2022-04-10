/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.StudentDepartment;

import static org.junit.jupiter.api.Assertions.*;

class StudentDepartmentFactoryTest {
@Test
    public void test(){
    StudentDepartment studentDepartment = new StudentDepartment(213063964, 1);
    System.out.println(studentDepartment.toString());

}
}