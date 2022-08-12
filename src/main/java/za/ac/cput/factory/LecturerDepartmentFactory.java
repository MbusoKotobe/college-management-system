package za.ac.cput.factory;
/**
 * LecturerDepartmentFactory.java;
 * This is LecturerDepartmentFactory domain factory class
 * @Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */
import za.ac.cput.repository.entity.LecturerDepartment;

public class LecturerDepartmentFactory {
    public static LecturerDepartment createLecturerDepartment(long lecturerId, int departmentId) {
        LecturerDepartment lecturerDepartment = new LecturerDepartment.Builder().setDepartmentId(departmentId)
                .setLecturerId(lecturerId)
                .build();
        return lecturerDepartment;
    }
}
