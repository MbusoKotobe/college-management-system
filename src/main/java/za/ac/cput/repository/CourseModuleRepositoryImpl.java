/* CourseModuleRepositoryImpl.java
Repository Implementation for the CourseModule
Author: Jody Kearns (209023651)
Date: 08 April 2022 */

package za.ac.cput.repository;

import za.ac.cput.entity.CourseModule;
import java.util.HashSet;
import java.util.Set;

public class CourseModuleRepositoryImpl implements ICourseModuleRepository{
    private static CourseModuleRepositoryImpl courseModuleRepo = null;
    private Set<CourseModule> courseModuleDB = null;

    private CourseModuleRepositoryImpl(){
        courseModuleDB = new HashSet<CourseModule>();
    }

    public static CourseModuleRepositoryImpl getCourseModuleRepository(){
        if (courseModuleRepo == null){
            courseModuleRepo = new CourseModuleRepositoryImpl();
        }
        return courseModuleRepo;
    }

    @Override
    public CourseModule create(CourseModule courseModule){
        boolean success = courseModuleDB.add(courseModule);
        if(!success)
            return null;
        return courseModule;
    }

    @Override
    public CourseModule read(Integer courseId){
        for (CourseModule e : courseModuleDB){
            if (e.getCourseId() == courseId)
                return e;
        }
        return null;
    }

    @Override
    public CourseModule update(CourseModule courseModule){
        CourseModule oldCourseModule = read(courseModule.getCourseId());
        if (oldCourseModule != null){
            courseModuleDB.remove(oldCourseModule);
            courseModuleDB.add(courseModule);
            return courseModule;
        }
        return null;
    }

    @Override
    public boolean delete(Integer courseId) {
        CourseModule courseModuleToDelete = read(courseId);
        if (courseId == null)
            return false;
        courseModuleDB.remove(courseModuleToDelete);
        return true;
    }

    @Override
    public Set<CourseModule> getAll(){
        return courseModuleDB;
    }
}
