package za.ac.cput.repository;
/**
 * ILecturerDepartmentRepository.java;
 * This interface is implemented by LecturerDepartmentRepository
 * @Author: Anele Aneal Tose - 216079292
 * Date: 09 April 2022
 */
import za.ac.cput.entity.LecturerDepartment;

import java.util.Set;

public interface ILecturerDepartmentRepository {
    public Set<LecturerDepartment> getAll();

    LecturerDepartment create (LecturerDepartment lecturerDepartment);

    LecturerDepartment read (long lecturerId, int departmentId);

    boolean delete(long lecturerId, int departmentId);
}
