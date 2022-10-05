/* CourseRepositoryImpl.java
Repository Implementation for the Course
Author: Jody Kearns (209023651)
Date: 07 April 2022 */

package za.ac.cput.repository;

import za.ac.cput.entity.Course;
import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryImpl implements ICourseRepository{
    private static CourseRepositoryImpl courseRepo = null;
    private Set<Course> courseDB = null;

    private CourseRepositoryImpl(){
        courseDB = new HashSet<Course>();
    }

    public static CourseRepositoryImpl getCourseRepository(){
        if (courseRepo == null){
            courseRepo = new CourseRepositoryImpl();
        }
        return courseRepo;
    }

    @Override
    public Course create(Course course){
        boolean success = courseDB.add(course);
        if(!success)
            return null;
        return course;
    }

    @Override
    public Course read(Integer courseId){
        for (Course e : courseDB){
            if (e.getCourseId() == courseId)
                return e;
        }
        return null;
    }

    @Override
    public Course update(Course course){
        Course oldCourse = read(course.getCourseId());
        if (oldCourse != null){
            courseDB.remove(oldCourse);
            courseDB.add(course);
            return course;
        }
        return null;
    }

    @Override
    public boolean delete(Integer courseId) {
        Course courseToDelete = read(courseId);
        if (courseId == null)
            return false;
        courseDB.remove(courseToDelete);
        return true;
    }

    @Override
    public Set<Course> getAll(){
        return courseDB;
    }
}
