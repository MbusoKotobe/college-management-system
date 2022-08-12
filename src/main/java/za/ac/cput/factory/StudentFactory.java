package za.ac.cput.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: Student Factory
ADP 3 Assignment Group1
*/


import za.ac.cput.repository.entity.Student;

public class StudentFactory
{
    public static Student createStudent (String firstName, String middleName, String lastName, long studentNumber)
    {
        Student student = new Student.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setStudentNumber(studentNumber)
                .build();
        return student;
    }
}