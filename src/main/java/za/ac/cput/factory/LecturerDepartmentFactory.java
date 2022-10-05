package za.ac.cput.factory;

import za.ac.cput.entity.LecturerDepartment;

/**
 * LecturerDepartmentFactory.java;
 * This is LecturerDepartmentFactory domain factory class
 * @Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */


public class LecturerDepartmentFactory {
    public static LecturerDepartment createLecturerDepartment(long lecturerId, int departmentId) {
        LecturerDepartment lecturerDepartment = new LecturerDepartment.Builder().setDepartmentId(departmentId)
                .setLecturerId(lecturerId)
                .build();
        return lecturerDepartment;
    }
}
