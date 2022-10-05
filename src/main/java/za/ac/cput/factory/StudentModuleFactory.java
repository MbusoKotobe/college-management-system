package za.ac.cput.factory;

/*
 * Zintle Magwaxaza (218109911)
 * StudentModuleFactory.java
 * Date: 08 April 2022
 */

import za.ac.cput.repository.entity.StudentModule;

public class StudentModuleFactory {

    public static StudentModule createStudentModule (long studentNumber, String moduleId) {

        StudentModule studentModule = new StudentModule.Builder()
                .setModuleId(moduleId)
                .setStudentNumber(studentNumber)
                .build();

        return studentModule;
    }
    }