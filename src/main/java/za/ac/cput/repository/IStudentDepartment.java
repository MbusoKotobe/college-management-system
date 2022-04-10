package za.ac.cput.repository;

import za.ac.cput.entity.StudentDepartment;

import java.util.Set;

public interface IStudentDepartment extends IRepository<StudentDepartment, String>{
    public Set<StudentDepartment> getAll();
}
