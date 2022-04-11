package za.ac.cput.repository;

/*
author: Ameer Ismail
student nr: 218216033
Repository: IStudentCourseRepository
ADP 3 Assignment Group1
implementation
*/

import za.ac.cput.entity.StudentCourse;
import java.util.Set;

public interface IStudentCourseRepository extends IRepository<StudentCourse, Integer>
{
    // CRUD
    public Set<StudentCourse> getAll();
}
