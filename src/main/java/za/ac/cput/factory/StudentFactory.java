package za.ac.cput.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: Student Factory
ADP 3 Assignment Group1
*/


import za.ac.cput.entity.Student;

public class StudentFactory
{
    public static Student createStudent (String firstName, String middleName, String lastName, long studentNumber)
    {
        return Student.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .studentNumber(studentNumber)
                .build();
    }
}