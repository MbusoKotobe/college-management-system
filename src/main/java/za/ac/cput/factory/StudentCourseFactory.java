package za.ac.cput.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: studentCourse Factory
ADP 3 Assignment Group1
*/


import za.ac.cput.repository.entity.StudentCourse;

public class StudentCourseFactory
{

    public static StudentCourse createStudentCourse(long studentNumber, int courseId)
    {

        StudentCourse studentCourse  = new StudentCourse.Builder()
                .setStudentNumber(studentNumber)
                .setCourseId(courseId)
                .build();
        return studentCourse;
    }
}
