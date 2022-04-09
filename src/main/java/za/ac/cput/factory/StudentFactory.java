package za.ac.cput.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: Student Factory
ADP 3 Assignment Group1
*/


import za.ac.cput.entity.Student;
import za.ac.cput.utility.Helper;

public class StudentFactory
{
    public static Student createStudent (String middleName, String lastName, long studentNumber)
    {
        String studentName = Helper.generateId();

        Student student = new Student.Builder()
                .setFirstName(studentName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setStudentNumber(studentNumber)
                .build();
        return student;
    }
}