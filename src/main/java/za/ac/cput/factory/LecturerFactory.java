package za.ac.cput.factory;
/**
 * LecturerFactory.java;
 * This is LecturerFactory domain factory class
 * @Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */
import za.ac.cput.entity.Faculty;
import za.ac.cput.entity.Lecturer;

import za.ac.cput.utility.Utilities;

public class LecturerFactory {
    public static Lecturer createLecturer(long lecturerId, String firstName, String middleName, String lastName){
        return Lecturer.builder().lecturerId(lecturerId)
                                 .firstName(firstName)
                                 .middleName(middleName)
                                 .lastName(lastName)
                                 .build();
    }
}
