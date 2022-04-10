package za.ac.cput.repository;


/*
author: Ameer Ismail
student nr: 218216033
Repository: StudentCourseRepositoryImpl
ADP 3 Assignment Group1
*/

import za.ac.cput.entity.StudentCourse;
import java.util.*;

public class StudentCourseRepositoryImpl implements IStudentCourseRepository
{

    //implementing the repo and the database
    private static StudentCourseRepositoryImpl repository = null;
    private Set<StudentCourse> studentCoursesDB = null;

    private StudentCourseRepositoryImpl()
    {
        studentCoursesDB = new HashSet<StudentCourse>();
    }

    //get repo
    public static StudentCourseRepositoryImpl getRepo()
    {
        if (repository == null)
        {
            repository = new StudentCourseRepositoryImpl();
        }
        return repository;
    }

    //creating the object
    @Override
    public StudentCourse create(StudentCourse studentCourse)
    {
        boolean success = studentCoursesDB.add(studentCourse);
        if (!success)
            return null;
        return studentCourse;
    }

    @Override
    public StudentCourse read(Integer courseId)
    {
        StudentCourse stud = studentCoursesDB.stream()
                .filter(s -> s.getCourseId() == courseId)
                .findAny()
                .orElse(null);
        return stud;
    }


    @Override
    public StudentCourse update(StudentCourse studentCourse)
    {
        StudentCourse oldStudentCourse = read(studentCourse.getCourseId());
        if (oldStudentCourse != null)
        {
            studentCoursesDB.remove(oldStudentCourse);
            studentCoursesDB.add(studentCourse);
            return studentCourse;
        }

        return null;
    }

    @Override
    public boolean delete(Integer courseId)
    {
        StudentCourse deleteStudentCourse = read(courseId);
        if (courseId == null)
            return false;

        studentCoursesDB.remove(deleteStudentCourse);
        return true;
    }


    @Override
    public Set<StudentCourse> getAll()
    {
        return studentCoursesDB;
    }

}