package za.ac.cput.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: studentCourse Factory
ADP 3 Assignment Group1
*/


import za.ac.cput.entity.StudentCourse;
import za.ac.cput.utility.Helper;

public class StudentCourseFactory
{

    public static StudentCourse createStudentCourse(int courseId)
    {
       // String studentCourseId = Helper.generateId();     --- needs attention to convert to an integer

        StudentCourse studentCourse  = new StudentCourse.Builder()
                .setStudentNumber(218247720)
                .setCourseId(courseId)
                .build();
        return studentCourse;
    }
}
