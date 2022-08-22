package za.ac.cput.repository;

/*
author: Ameer Ismail
student nr: 218216033
Repository: IStudentCourseRepository
ADP 3 Assignment Group1
implementation
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.StudentCourse;

public interface IStudentCourseRepository extends JpaRepository<StudentCourse, Integer>
{
}
