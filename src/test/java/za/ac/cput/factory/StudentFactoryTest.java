package za.ac.cput.factory;

/*
author: Ameer Ismail
student nr: 218216033
factory: testing student factory class
ADP 3 Assignment Group1
*/


import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest
{
    @Test
    void createStudent()
    {
        Student student = StudentFactory.createStudent("jason", "williams", 328738445);
        assertNotNull(student);
        System.out.println(student);
    }

}