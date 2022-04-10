package za.ac.cput.factory;
/**
 * LecturerFactory.java;
 * This is LecturerFactory domain factory class
 * @Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */
import za.ac.cput.entity.Lecturer;

import za.ac.cput.utility.Utilities;

public class LecturerFactory {
    public static Lecturer createLecturer(String firstName, String lastName){
        long lecturerId = Utilities.generateId();
        Lecturer lecturer = new Lecturer.Builder().setLectureId(lecturerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return lecturer;
    }
}
