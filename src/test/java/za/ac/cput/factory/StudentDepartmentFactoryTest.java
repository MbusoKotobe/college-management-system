package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.StudentDepartment;

import static org.junit.jupiter.api.Assertions.*;

class StudentDepartmentFactoryTest {
@Test
    public void test(){
    StudentDepartment studentDepartment = new StudentDepartment("213063964", "323232323233");
    System.out.println(studentDepartment.toString());

}
}